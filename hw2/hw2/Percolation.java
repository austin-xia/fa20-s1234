package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private int[] root;
    private int open_sites;
    private int length;
    private WeightedQuickUnionUF DS_helper;
    //master_top is the key for isFull
    //store the first opened first-row-element
    //and connect other opened first-row-element with this master_top
    private int master_top;
    private int master_bottom;

    /* convert the row/col to the number count direct for array, row/col starts from 0/0
    eg, 0/0 should be converted to 0
    3/2 with N=4 should be converted to 14 **/
    private int twoD_oneD (int row, int col){
        if (row > length || col > length){
            throw new IllegalArgumentException("input row or col exceed limit");
        }
        return row*length + col;
    }

    private int[] oneD_twoD (int num){
        int[] helper = new int[2];
        helper[0] = num/length;
        helper[1] = num%length;
        return helper;
    }

    /* create N-by-N grid, with all sites initially blocked */
    public Percolation(int N){
        if (N <= 0){
            throw new IllegalArgumentException("input must be a positive number");
        }
        root = new int [N*N];
        open_sites = 0;
        length = N;
        DS_helper = new WeightedQuickUnionUF(length*length);
        master_top = -1;
        master_bottom = -1;


        /* cannot use the concept below (virtual top/bottom)
        as GUI will display all units connected once any of them is full
        so the entire bottom row will be displayed once any of them is opened and full.
         */
        //int constructor_helper = length*length-1;
        //for (int i = 0; i < length; i += 1){
        //    DS_helper.union(length*length, i);
        //    DS_helper.union(length*length+1, constructor_helper);
        //    constructor_helper -= 1;
        //}
    }

    /* open the site (row, col) if it is not open already */
    public void open(int row, int col){
        int num = twoD_oneD(row, col);
        root [num] = 1;
        open_sites += 1;

        /* make the first opened top row site as the master_top,
        then connect all other opened first row sites to it.
         */
        if (row == 0){
            if (master_top == -1){
                master_top = num;
            }
            DS_helper.union(master_top, num);
        }

        /* make the first opened bottom row site as the master_bottom,
        then connect all other opened bottom row sites to it.
         */
        if (row == length -1){
            if (master_bottom == -1){
                master_bottom = num;
            }
            DS_helper.union(master_bottom, num);
        }

        if (row > 0 && isOpen(row-1, col)){
            DS_helper.union(num, twoD_oneD(row-1, col));
        }
        if (row + 1 < length && isOpen(row+1, col)){
            DS_helper.union(num, twoD_oneD(row+1, col));
        }
        if (col > 0 && isOpen(row, col-1)){
            DS_helper.union(num, twoD_oneD(row, col-1));
        }
        if (col + 1 < length && isOpen(row, col+1)){
            DS_helper.union(num, twoD_oneD(row, col+1));
        }
    }

    /* is the site (row, col) open? */
    public boolean isOpen(int row, int col){
        int num = twoD_oneD(row, col);
        return root [num] == 1;
    }

    /* is the site (row, col) full? */
    public boolean isFull(int row, int col){
        int num = twoD_oneD(row, col);
        if (master_top == -1){
            return false;
        }
        return DS_helper.connected(num, master_top);
    }

    /* number of open sites */
    public int numberOfOpenSites(){
        return open_sites;
    }

    /* does the system percolate? */
    public boolean percolates(){
        if (master_top == -1 || master_bottom == -1){
            return false;
        }
        return DS_helper.connected(master_top, master_bottom);
    }


    public static void main(String[] args){

    }
}
