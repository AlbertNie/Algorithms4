/**
 * Created by albert on 2017/5/8.
 */
public class lunwen {
    static class Fu{
        double r;
        double q;
        double sg;

        public Fu(double r, double q, double sg) {
            this.r = r;
            this.q = q;
            this.sg = sg;
        }
        public double getH(){
            return r*Math.sqrt((3*q)/(4*sg));
        }

    }
    static class nieyu{
        double v;
        double q;
        double r;
        double sg;
        double Nr;

        public nieyu(double v, double q, double r, double sg, double nr) {
            this.v = v;
            this.q = q;
            this.r = r;
            this.sg = sg;
            Nr = nr;
        }

        public double getH(){
            return Math.sqrt((3*(3+v)*q*r*r)/(8*(sg+Nr)));
        }
    }

    public static void main(String[] args) {
        double q = 800;
        double r = 4.2;
        double v = 0.21;
        double sg = 3500;
        double Nr = 10000;
        Fu fu = new Fu(r,q,sg);
        nieyu niey = new nieyu(v,q,r,sg,Nr);
        System.out.println("----------云雾山隧道---------");
        System.out.println(fu.getH()+"m是付师兄的结果");
        System.out.println(niey.getH()+"m是我的结果");
        System.out.println("实际预留厚度为2.5m");
        System.out.println("付师兄的结果比我的结果大"+(fu.getH()/niey.getH())*100+"%左右");
        System.out.println("付师兄的结果占实际工程厚度的比重："+fu.getH()/2.5);
        System.out.println("我的结果占实际工程厚度的比重："+niey.getH()/2.5);

        System.out.println("----------------------------");
        q = 1200;
        sg = 3400;
        v = 0.2;
        r = 4.2;
        Nr = 10000;
        fu = new Fu(r,q,sg);
        niey = new nieyu(v,q,r,sg,Nr);
        System.out.println("----------马鹿隧道泄水前的厚度---------");
        System.out.println(fu.getH()+"m是付师兄的结果");
        System.out.println(niey.getH()+"m是我的结果");
        System.out.println("根据论文资料，此处工程中实际预留厚度在1-1.5m");
        System.out.println("付师兄的结果比我的结果大"+(fu.getH()/niey.getH())*100+"%左右");
        System.out.println("付师兄的结果占实际工程厚度的比重："+fu.getH()/1.5);
        System.out.println("我的结果占实际工程厚度的比重："+niey.getH()/1.5);
        System.out.println("------------------------------------");

        fu.q = 350;
        niey.q = 350;
        System.out.println("-----------马鹿隧道泄水后的厚度--------");
        System.out.println(fu.getH()+"m是付师兄的结果");
        System.out.println(niey.getH()+"m是我的结果");
        System.out.println("根据论文中的资料现实，此处工程中实际预留厚度为1m左右");
        System.out.println("付师兄的结果比我的结果大"+(fu.getH()/niey.getH())*100+"%左右");
        System.out.println("付师兄的结果占实际工程厚度的比重："+fu.getH()/1.0);
        System.out.println("我的结果占实际工程厚度的比重："+niey.getH()/1.0);
        System.out.println("-------------------------------------");
    }
}
