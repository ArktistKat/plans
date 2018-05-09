package plants_simulation;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vir_ArktistKat
 */
public class EuKaryota {
        ArrayList<Puffancs> puf;
        ArrayList<Deltafa> del;
        ArrayList<Parabokor> par;
        int aradiation,dradiation;
        
        public EuKaryota() {
            puf = new ArrayList<Puffancs>();
            del = new ArrayList<Deltafa>();
            par = new ArrayList<Parabokor>();
            this.aradiation=0;
            this.dradiation=0;     
        }

    public void fileRead(String InputFileName)  throws IOException {
	BufferedReader br = null;
	FileReader fr = null;
	fr = new FileReader(InputFileName);
	br = new BufferedReader(fr);
        String line = br.readLine();
        for (int i=Integer.parseInt(line);i>0;--i) {
            line = br.readLine();
            String[] linetmp=line.split(" ");
            if(linetmp[1].equals("a")) {
                puf.add(Puffancs.makePuffancs(linetmp[0],Integer.parseInt(linetmp[2])));
            }
            if(linetmp[1].equals("d")) {
                del.add(Deltafa.makeDeltafa(linetmp[0],Integer.parseInt(linetmp[2])));
            }
            if(linetmp[1].equals("p")) {
                par.add(Parabokor.makeParabokor(linetmp[0],Integer.parseInt(linetmp[2])));
            }
        }
        int days = Integer.parseInt(br.readLine());
        br.close();
	fr.close(); 
        simulate(days);   
    }
    
    public void simulate(int days) {
        firstDay();
        isDead(1);
        for(int i=2;i<=days;i++) {
            int difference=this.aradiation-this.dradiation;
            //System.out.println(">>>>>>>>>"+difference+" : : : alpha: "+ this.aradiation+" : : : delta: "+ this.dradiation);
            System.out.println(">>>>>>>>> uj nap:"+i+". : Diff: "+Math.abs(difference)+" : : : alpha: "+ this.aradiation+" : : : delta: "+ this.dradiation);
            if(Math.abs(difference)<3) {
                System.out.println("> Nincs sugarzas");
                for(Puffancs a:puf) {
                    this.aradiation=a.noRadaition(this.aradiation);
                }
                for(Deltafa a:del) {
                    this.dradiation=a.noRadaition(this.dradiation);
                }
                for(Parabokor a:par) {
                    this.aradiation=a.noRadaition(this.aradiation);
                }
            }
            else if(this.aradiation<this.dradiation) {
                System.out.println("> Delta sugarzas");
                for(Puffancs a:puf) {
                    this.aradiation=a.deltaRadaition(this.aradiation);
                }
                for(Deltafa a:del) {
                    this.dradiation=a.deltaRadaition(this.dradiation);
                }
                for(Parabokor a:par) {
                    this.aradiation=a.deltaRadaition(this.aradiation);
                }
            }
            else  {
                System.out.println("> Alpha sugarzas");
                for(Puffancs a:puf) {
                    this.aradiation=a.alphaRadaition(this.aradiation);
                }
                for(Deltafa a:del) {
                    this.dradiation=a.alphaRadaition(this.dradiation);
                }
                for(Parabokor a:par) {
                    this.aradiation=a.alphaRadaition(this.aradiation);
                }
            }
            isDead(i);
        }
    }
    
    public void firstDay() {
        System.out.println("> Nincs sugarzas");
        for(Puffancs i:puf) {
            this.aradiation=i.noRadaition(this.aradiation);
        }
        for(Deltafa i:del) {
            this.dradiation=i.noRadaition(this.dradiation);
        }
        for(Parabokor i:par) {
            this.aradiation=i.noRadaition(this.aradiation);
        }
    }
    public void isDead(int day) {
        for(int a=0;a<puf.size();a++) {
            if(puf.get(a).getAlive()==false) {
                System.out.println(">> "+puf.get(a).getName() + " " + (day-1) + ". napon elhalt");
                puf.remove(a);
            }
        }
        for(int a=0;a<del.size();a++) {
            if(del.get(a).getAlive()==false) {
                System.out.println(">> "+del.get(a).getName() + " " + (day-1) + ". napon elhalt");
                del.remove(a);
            }
        }
        for(int a=0;a<par.size();a++) {
            if(par.get(a).getAlive()==false) {
                System.out.println(">> "+par.get(a).getName() + " " + (day-1) + ". napon elhalt");
                par.remove(a);
            }
        }
        writeConsole(day);
    }
    
    public void writeConsole(int day) {
        System.out.println(">>> "+ day + ". nap allasa:");
        for(Puffancs i:puf) {
            System.out.println(i.getName() + " " + i.getWater() + "");
        }
        for(Deltafa i:del) {
            System.out.println(i.getName() + " " + i.getWater() + "");
        }
        for(Parabokor i:par) {
            System.out.println(i.getName() + " " + i.getWater() + "");
        }
    }
}
