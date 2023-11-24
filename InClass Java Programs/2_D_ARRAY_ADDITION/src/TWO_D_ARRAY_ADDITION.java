
public class TWO_D_ARRAY_ADDITION 
{

    public static void main(String[] args) 
    {
        int arr1[][]={{1,2,3},{4,5,6}};
        int arr2[][]={{1,2,3},{4,5,6}};
        
        System.out.println("ADDITION OF 2-D ARRAYS : ");
        
        for(int i=0;i<2;i++)
        {
            for(int j=0;j<3;j++)
            {
                System.out.print(arr1[i][j]+arr2[i][j]+"\t");
            }
            System.out.println("\n");
        }
    }
    
}
