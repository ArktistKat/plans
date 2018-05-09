/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plants_simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Vir_ArktistKat
 */
public class Plants_simulation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        try {
            EuKaryota s1 = new EuKaryota();
            BufferedReader br = null;
            br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Mielott elkezdodhetne a moka....kerem a fajl nevet : ");
            String input = br.readLine();
            br.close();
            s1.fileRead(input);
        }
	catch (Exception e) {
            e.printStackTrace();
        }
    }
}