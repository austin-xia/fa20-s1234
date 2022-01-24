public class NBody {
    public static double readRadius (String filename) {
        In in = new In (filename);
        in.readDouble();
        double Radius = in.readDouble();
        return Radius;
    }
    /* import the bodies and return a array with all created body objects from the txt file **/
    public static Body[] readBodies (String filename) {
        In in = new In (filename);
        double numofbodies = in.readDouble();
        Body[] Bodies = new Body[(int)numofbodies];
        double Radius = in.readDouble();
        int counter = 0;
        while (counter < numofbodies){
            double xxpos = in.readDouble();
            double yypos = in.readDouble();
            double xxvel = in.readDouble();
            double yyvel = in.readDouble();
            double mass = in.readDouble();
            String imagename = in.readString();
            Bodies[counter] = new Body (xxpos, yypos, xxvel, yyvel, mass, imagename);
            counter += 1;
        }
        return Bodies;
    }


    public static void main (String[] args) {
        double T = Double.valueOf(args[0]);
        double dt = Double.valueOf(args[1]);
        String filename = args[2];
        double Radius = readRadius(filename);
        Body[] Bodies = readBodies(filename);

        /* draw and update to generate animation **/
        for (double timestamp = 0; timestamp <= T; timestamp += dt){

            /* draw universe **/
            String imageToDraw = "images/starfield.jpg";
            StdDraw.enableDoubleBuffering();
            StdDraw.setScale(Radius*-1, Radius);
            StdDraw.clear();
            StdDraw.picture(0, 0, imageToDraw);

            /* draw the bodies **/
            for (Body N:Bodies){
                N.draw();
            }

            /* show pics and hold**/
            StdDraw.show();
            StdDraw.pause(5);

            /*update for next timestamp **/
            /* generate a array for netforce x and y, need to do this for all bodies before any updates **/
            double[] NetForcesX = new double [Bodies.length];
            double[] NetForcesY = new double [Bodies.length];
            for (int i = 0; i < Bodies.length; i += 1 ) {
                NetForcesX[i] = Bodies[i].calcNetForceExertedByX(Bodies);
                NetForcesY[i] = Bodies[i].calcNetForceExertedByY(Bodies);
            }

            for (int i = 0; i < Bodies.length; i += 1 ) {
                Bodies[i].update(dt, NetForcesX[i], NetForcesY[i]);
            }

        }







        


    }
}
