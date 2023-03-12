public class ClassNameHere {
    public static void windowPosSum(int[] a, int n) {
        
        int b[] = a.clone();
        
        for (int i = 0; i < a.length; i+=1){
          //  System.out.println("i ="+i+" "+a[i]);
    
            for (int j =1; j<=n; j+=1){
              //  System.out.println("j ="+j+" i+j= "+(i+j));
                if (b[i]<0){
                //    System.out.println("contine at a[i]<0");
                    continue;
                }
                if ((j+i+1)>b.length){
                    // System.out.println("contine at j+i+1>lengt");
                    continue;
                }
                System.out.println("a["+i+"] = a["+i+"]+a["+(j+i)+"]");
                a[i]=a[i]+a[j+i];
            }
        }
    
       System.out.println(java.util.Arrays.toString(a));
       }
       public static void main(String[] args) {
          int[] nums = new int[]{1, -1, -1, 10, 5, -1};  
    
          int n = 2;
          
          windowPosSum(nums,n);
    
       }
    }