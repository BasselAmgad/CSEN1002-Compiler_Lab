package csen1002.tests.task6;

import csen1002.main.task6.FFCFG;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstFollowTests {

    // public s21
    @Test
    @Timeout(5)
    public void Test_7_public_1_first() {
        FFCFG f = new FFCFG("S,aBDh;B,cA;A,bA,e;D,EF;E,g,e;F,f,e");
        assertEquals("S,a;B,c;A,be;D,efg;E,eg;F,ef", f.first());
    }

    @Test
    @Timeout(5)
    public void Test_7_public_1_follow() {
        FFCFG f = new FFCFG("S,aBDh;B,cA;A,bA,e;D,EF;E,g,e;F,f,e");
        assertEquals("S,$;B,fgh;A,fgh;D,h;E,fh;F,h", f.follow());
    }

    @Test
    @Timeout(5)
    public void Test_7_public_2_first() {
        FFCFG f = new FFCFG("S,A;A,aY,Ad;Y,b");
        assertEquals("S,a;A,a;Y,b", f.first());
    }

    @Test
    @Timeout(5)
    public void Test_7_public_2_follow() {
        FFCFG f = new FFCFG("S,A;A,aY,Ad;Y,b");
        assertEquals("S,$;A,d$;Y,d$", f.follow());
    }

    @Test
    @Timeout(5)
    public void Test_7_public_3_first() {
        FFCFG f = new FFCFG("S,bLc,a;L,SN;N,kSN,e");
        assertEquals("S,ab;L,ab;N,ek", f.first());
    }

    @Test
    @Timeout(5)
    public void Test_7_public_3_follow() {
        FFCFG f = new FFCFG("S,bLc,a;L,SN;N,kSN,e");
        assertEquals("S,ck$;L,c;N,c", f.follow());
    }

    @Test
    @Timeout(5)
    public void Test_7_public_4_first() {
        FFCFG f = new FFCFG("S,Sa,B;B,cB,D;D,o,e");
        assertEquals("S,aceo;B,ceo;D,eo", f.first());
    }

    @Test
    @Timeout(5)
    public void Test_7_public_4_follow() {
        FFCFG f = new FFCFG("S,Sa,B;B,cB,D;D,o,e");
        assertEquals("S,a$;B,a$;D,a$", f.follow());
    }

    @Test
    @Timeout(5)
    public void Test_7_public_5_first() {
        FFCFG f = new FFCFG("S,ACB,CbB,Ba;A,da,BC;B,g,e;C,h,e");
        assertEquals("S,abdegh;A,degh;B,eg;C,eh", f.first());
    }

    @Test
    @Timeout(5)
    public void Test_7_public_5_follow() {
        FFCFG f = new FFCFG("S,ACB,CbB,Ba;A,da,BC;B,g,e;C,h,e");
        assertEquals("S,$;A,gh$;B,agh$;C,bgh$", f.follow());
    }

    // 7_1
    @Test
    @Timeout(5)
    public void Test_7_1_1_first() {
        FFCFG f = new FFCFG("S,sk,A;P,xSdP,k,e;A,Pcat,s");
        assertEquals("S,cksx;P,ekx;A,cksx", f.first());
    }

    @Test
    @Timeout(5)
    public void Test_7_1_1_follow() {
        FFCFG f = new FFCFG("S,sk,A;P,xSdP,k,e;A,Pcat,s");
        assertEquals("S,d$;P,c;A,d$", f.follow());
    }

    @Test
    @Timeout(5)
    public void Test_7_1_2_first() {
        FFCFG f = new FFCFG("S,oPZ,o,SpP;Z,ppSP,Poo,e;P,PS,xq,e");
        assertEquals("S,o;Z,eopx;P,eox", f.first());
    }

    @Test
    @Timeout(5)
    public void Test_7_1_2_follow() {
        FFCFG f = new FFCFG("S,oPZ,o,SpP;Z,ppSP,Poo,e;P,PS,xq,e");
        assertEquals("S,opx$;Z,opx$;P,opx$", f.follow());
    }

    @Test
    @Timeout(5)
    public void Test_7_1_3_first() {
        FFCFG f = new FFCFG("S,SdSjj,dLa,e;L,dwL,to,e");
        assertEquals("S,de;L,det", f.first());
    }

    @Test
    @Timeout(5)
    public void Test_7_1_3_follow() {
        FFCFG f = new FFCFG("S,SdSjj,dLa,e;L,dwL,to,e");
        assertEquals("S,dj$;L,a", f.follow());
    }

    @Test
    @Timeout(5)
    public void Test_7_1_4_first() {
        FFCFG f = new FFCFG("S,UzQ,yzS,dz;N,Nndz,rS,rdN;Q,rrUn,guc;U,N,UiSu");
        assertEquals("S,dry;N,r;Q,gr;U,r", f.first());
    }

    @Test
    @Timeout(5)
    public void Test_7_1_4_follow() {
        FFCFG f = new FFCFG("S,UzQ,yzS,dz;N,Nndz,rS,rdN;Q,rrUn,guc;U,N,UiSu");
        assertEquals("S,inuz$;N,inz;Q,inuz$;U,inz", f.follow());
    }

    @Test
    @Timeout(5)
    public void Test_7_1_5_first() {
        FFCFG f = new FFCFG("S,vHv,Tf,e;H,Sa,vSz,an,e;T,aT,kqd,xdl");
        assertEquals("S,aekvx;H,aekvx;T,akx", f.first());
    }

    @Test
    @Timeout(5)
    public void Test_7_1_5_follow() {
        FFCFG f = new FFCFG("S,vHv,Tf,e;H,Sa,vSz,an,e;T,aT,kqd,xdl");
        assertEquals("S,az$;H,v;T,f", f.follow());
    }

    //7_2
    @Test
    @Timeout(5)
    public void Test_7_2_1_first() {
        FFCFG f = new FFCFG("S,T,e;M,Ta,abM;R,RbM,kop;T,Rq,gh,e");
        assertEquals("S,egk;M,agk;R,k;T,egk", f.first());
    }

    @Test
    @Timeout(5)
    public void Test_7_2_1_follow() {
        FFCFG f = new FFCFG("S,T,e;M,Ta,abM;R,RbM,kop;T,Rq,gh,e");
        assertEquals("S,$;M,bq;R,bq;T,a$", f.follow());
    }

    @Test
    @Timeout(5)
    public void Test_7_2_2_first() {
        FFCFG f = new FFCFG("S,jS,fY;Y,kjS,k,XR,e;X,Sk,fRfk;R,jXzR,uoc");
        assertEquals("S,fj;Y,efjk;X,fj;R,ju", f.first());
    }

    @Test
    @Timeout(5)
    public void Test_7_2_2_follow() {
        FFCFG f = new FFCFG("S,jS,fY;Y,kjS,k,XR,e;X,Sk,fRfk;R,jXzR,uoc");
        assertEquals("S,k$;Y,k$;X,juz;R,fk$", f.follow());
    }

    @Test
    @Timeout(5)
    public void Test_7_2_3_first() {
        FFCFG f = new FFCFG("S,Qt,t;Q,Rc,dS;R,RttS,na,e");
        assertEquals("S,cdnt;Q,cdnt;R,ent", f.first());
    }

    @Test
    @Timeout(5)
    public void Test_7_2_3_follow() {
        FFCFG f = new FFCFG("S,Qt,t;Q,Rc,dS;R,RttS,na,e");
        assertEquals("S,ct$;Q,t;R,ct", f.follow());
    }

    @Test
    @Timeout(5)
    public void Test_7_2_4_first() {
        FFCFG f = new FFCFG("S,Sjpp,jYSp,p;Y,Ys,ttj,p");
        assertEquals("S,jp;Y,pt", f.first());
    }

    @Test
    @Timeout(5)
    public void Test_7_2_4_follow() {
        FFCFG f = new FFCFG("S,Sjpp,jYSp,p;Y,Ys,ttj,p");
        assertEquals("S,jp$;Y,jps", f.follow());
    }

    @Test
    @Timeout(5)
    public void Test_7_2_5_first() {
        FFCFG f = new FFCFG("S,yll,NTFy,ySuF,e;F,Fyz,lol,e;N,TFT,yoy;T,FS,lTN,e");
        assertEquals("S,ely;F,ely;N,ely;T,ely", f.first());
    }

    @Test
    @Timeout(5)
    public void Test_7_2_5_follow() {
        FFCFG f = new FFCFG("S,yll,NTFy,ySuF,e;F,Fyz,lol,e;N,TFT,yoy;T,FS,lTN,e");
        assertEquals("S,luy$;F,luy$;N,ly;T,ly", f.follow());
    }

    //7_extra
    @Test
    @Timeout(5)
    public void Test_7_extra_1_first() {
        FFCFG f = new FFCFG("S,tOlS,d;O,OQ,zSzQ,z,e;Q,Qz,s,e");
        assertEquals("S,dt;O,esz;Q,esz", f.first());
    }

    @Test
    @Timeout(5)
    public void Test_7_extra_1_follow() {
        FFCFG f = new FFCFG("S,tOlS,d;O,OQ,zSzQ,z,e;Q,Qz,s,e");
        assertEquals("S,z$;O,lsz;Q,lsz", f.follow());
    }

    @Test
    @Timeout(5)
    public void Test_7_extra_2_first() {
        FFCFG f = new FFCFG("S,cOS,ftE,f;O,ccft,SES,e;E,tO,tw");
        assertEquals("S,cf;O,cef;E,t", f.first());
    }

    @Test
    @Timeout(5)
    public void Test_7_extra_2_follow() {
        FFCFG f = new FFCFG("S,cOS,ftE,f;O,ccft,SES,e;E,tO,tw");
        assertEquals("S,cft$;O,cft$;E,cft$", f.follow());
    }

    @Test
    @Timeout(5)
    public void Test_7_extra_3_first() {
        FFCFG f = new FFCFG("S,XSqX,SoXt,key;X,qtrX,mn,b");
        assertEquals("S,bkmq;X,bmq", f.first());
    }

    @Test
    @Timeout(5)
    public void Test_7_extra_3_follow() {
        FFCFG f = new FFCFG("S,XSqX,SoXt,key;X,qtrX,mn,b");
        assertEquals("S,oq$;X,bkmoqt$", f.follow());
    }

    @Test
    @Timeout(5)
    public void Test_7_extra_4_first() {
        FFCFG f = new FFCFG("S,SpHr,a;T,STH,pUr,yU;H,SrH,Uio,e;U,hi,a");
        assertEquals("S,a;T,apy;H,aeh;U,ah", f.first());
    }

    @Test
    @Timeout(5)
    public void Test_7_extra_4_follow() {
        FFCFG f = new FFCFG("S,SpHr,a;T,STH,pUr,yU;H,SrH,Uio,e;U,hi,a");
        assertEquals("S,apry$;T,ah;H,ahr;U,ahir", f.follow());
    }

    @Test
    @Timeout(5)
    public void Test_7_extra_5_first() {
        FFCFG f = new FFCFG("S,Szf,QzQQ,dok;Q,fScz,zie,zf");
        assertEquals("S,dfz;Q,fz", f.first());
    }

    @Test
    @Timeout(5)
    public void Test_7_extra_5_follow() {
        FFCFG f = new FFCFG("S,Szf,QzQQ,dok;Q,fScz,zie,zf");
        assertEquals("S,cz$;Q,cfz$", f.follow());
    }
}
