import java.io.*;
import java.util.*;
import java.math.*;

class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i = 0; t_i < T; t_i++)
        {
            int N = Integer.parseInt(br.readLine().trim());
            String[] arr_Arr = br.readLine().split(" ");
            int[] Arr = new int[N];
            for(int i_Arr = 0; i_Arr < arr_Arr.length; i_Arr++)
            {
                Arr[i_Arr] = Integer.parseInt(arr_Arr[i_Arr]);
            }

            int out_ = Solve(N, Arr);
            System.out.println(out_);

        }

        wr.close();
        br.close();
    }
    static int Solve(int N, int[] Arr){
        // Return the answer

       int subSize=(int)Math.pow(2,N);
       int[]temp=new int[subSize];
       int count=0;
        ArrayList<Integer>arrList=new ArrayList<>();
       for(int i=1;i<subSize;i++){

           System.out.println();
           for (int j = 0; j < N; j++) {
               if(BigInteger.valueOf(i).testBit(j)){
                   System.out.println(Arr[j]+" ");
                   temp[count++]=Arr[j];
                   arrList.add(Arr[j]);
               }
           }
       }
        int result = 0;

        return result;

    }

}
