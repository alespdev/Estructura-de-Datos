import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int a_arrSize;
    static String v_arrs="";
  public static void main(String[] args) throws IOException {
    Insercion oInser= new Insercion();
    Seleccion oSelec = new Seleccion();
    BufferedReader oBufr = new BufferedReader(new InputStreamReader(System.in));
    long v_timeIni, v_timeFin;
    float v_time;
    System.out.println("De que tamaño sera el arreglo??");
    a_arrSize=Integer.parseInt(oBufr.readLine());
    int[] v_arr = new int[a_arrSize];
    for(int i=0; i<v_arr.length; i++){
        v_arr[i]=Integer.parseInt(oBufr.readLine());
    }
    for(int i=0;i<v_arr.length; i++){
        v_arrs=v_arrs+" "+v_arr[i]+" ";
    }
    System.out.println("Arreglo Inicial:");
    System.out.println("["+v_arrs+"]");
    System.out.println("");

    v_timeIni= System.currentTimeMillis();
    oInser.Ordenar(v_arr);
    v_timeFin=System.currentTimeMillis();
    v_time=(float)((v_timeFin-v_timeIni));
    System.out.println("Tiempo de Ejecucion: "+v_time+" Milisegundos");
    System.out.println("");

    v_timeIni=System.currentTimeMillis();
    oSelec.Ordenar(v_arr);
    v_timeFin=System.currentTimeMillis();
    v_time=(float)((v_timeFin-v_timeIni));
    System.out.println("Tiempo de Ejecucion: "+v_time+" Milisegundos");
    System.out.println("");

    }
}
class Insercion{
    int[] a_Arr;
    void Ordenar(int[] p_arr){
        String v_arrs="";
        a_Arr=p_arr;
        for(int i=1; i<a_Arr.length;i++){
            if(a_Arr[i]<a_Arr[i-1]){
                int v_temp=a_Arr[i];
                int j=i;
                do{
                    a_Arr[j]=a_Arr[j-1];
                    a_Arr[j-1]=v_temp;
                    j--;
                }while(j>0 && v_temp<a_Arr[j-1]);
            }
        }
        for(int i=0;i<a_Arr.length; i++){
            v_arrs=v_arrs+" "+a_Arr[i]+" ";
        }
        System.out.println("Arreglo Ordenado por Insercion:");
        System.out.println("["+v_arrs+"]");

    }
}
class Seleccion{
    void Ordenar(int[] p_arr){
        String v_arrs="";
        for(int j=0; j<p_arr.length;j++){
            int v_aux=j;
            int v_temp;
            for(int i=j+1;i<p_arr.length;i++){
                if(p_arr[v_aux]>p_arr[i])
                    v_aux=i;
                v_temp=p_arr[j];
                p_arr[j]=p_arr[v_aux];
                p_arr[v_aux]=v_temp;
            }
        }
        for(int i=0;i<p_arr.length; i++){
            v_arrs=v_arrs+" "+p_arr[i]+" ";
        }
        System.out.println("Arreglo Ordenado por Seleccion:");
        System.out.println("["+v_arrs+"]");

    }
}