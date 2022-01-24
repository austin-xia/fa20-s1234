public class Body {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public static double G = 6.67e-11;
    public Body (double xxp, double yyp, double xxv, double yyv,double mass,String img) {
        this.xxPos = xxp;
        this.yyPos = yyp;
        this.xxVel = xxv;
        this.yyVel = yyv;
        this.mass = mass;
        this.imgFileName = img;
    }
    public Body (Body b) {
        this.xxPos = b.xxPos;
        this.yyPos = b.yyPos;
        this.xxVel = b.xxVel;
        this.yyVel = b.yyVel;
        this.mass = b.mass;
        this.imgFileName = b.imgFileName;
    }
    public double calcDistance (Body N) {
        double Deltax = this.xxPos - N.xxPos;
        double Deltay = this.yyPos - N.yyPos;
        double distance = Math.sqrt((Deltax*Deltax) + (Deltay*Deltay));
        return distance;
    }
    public double calcForceExertedBy (Body N) {
        double distance = this.calcDistance (N);
        double force = 0;
        if (distance != 0) {
            force = (G * this.mass * N.mass)/ (distance * distance);
        }
        return force;
    }
    public double calcForceExertedByX (Body N) {
        double Totalforce = this.calcForceExertedBy(N);
        double ForceX = 0;
        if (this.calcDistance(N) != 0) {
            ForceX = Totalforce * (N.xxPos - this.xxPos) / this.calcDistance(N);
        }    
        return ForceX;
    }
    public double calcForceExertedByY (Body N) {
        double Totalforce = this.calcForceExertedBy(N);
        double ForceY = 0;
        if (this.calcDistance(N) != 0) {
            ForceY = Totalforce * (N.yyPos - this.yyPos) / this.calcDistance(N);
        }
        return ForceY;
    }
    public double calcNetForceExertedByX (Body[] array) {
        double NetForceX = 0;
        for (Body I:array) {
            NetForceX += this.calcForceExertedByX(I);
        }
        return NetForceX;
    }
    public double calcNetForceExertedByY (Body[] array) {
        double NetForceY = 0;
        for (Body I:array) {
            NetForceY += this.calcForceExertedByY(I);
        }
        return NetForceY;
    }

    /* update the position and velosity of this body with a constant NFX/NFY applied for dt **/
    public void update (double dt, double NetForceX, double NetForceY) {
        double AcceX = NetForceX / this.mass;
        double AcceY = NetForceY / this.mass;
        this.xxVel += AcceX * dt;
        this.yyVel += AcceY * dt;
        this.xxPos += this.xxVel * dt;
        this.yyPos += this.yyVel * dt;
    }

    /* draw the body **/
    public void draw () {
        String imagetodraw = "images/" + imgFileName;
        StdDraw.enableDoubleBuffering();
        /* StdDraw.setScale(-1e+10, 1e+10); **/
        StdDraw.picture(this.xxPos, this.yyPos, imagetodraw);
    }
}
