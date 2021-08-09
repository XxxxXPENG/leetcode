package sf.sort;

import java.util.Arrays;

public class Dui_sort {
    public static void main(String[] args) {
        int[] nums = {16,7,3,20,17,8 };
        headSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void headSort(int[ ] arr){
        //构造初始堆
        for(int i = arr.length/2-1; i >= 0; i--){
            headAdjust(arr,arr.length,i);
        }
        //排序，将最大的节点放在堆尾，然后从根节点重新排序
        for (int i = arr.length-1; i >= 1; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            headAdjust(arr,i,0);
        }
    }

    /**
     * k从第一个非叶子节点开始（右下角第1个节点），index为左右孩子较大者，然后与父节点交换 ；
     * 然后将改变的下一个节点k变为index，下标index改为 2*k+1；
     * 知道形成大根堆
     * @param arr   数组
     * @param len   要排的长度，即结束的标志
     * @param i     从哪个开始
     */
    public static void headAdjust(int[ ] arr,int len,int i){
        //temp 为父节点, index 为左子树的下标
        int k = i,temp = arr[i],index = 2 * i + 1;
        while(index < len){
            //选出子节点中较大的
            if(index + 1 < len){
                if(arr[index] < arr[index + 1])
                    index = index + 1;
            }
            //子节点大于父节点，交换子节点和父节点
            if(arr[index] > temp){
                arr[k] = arr[index];
                k = index;   //意思是只要交换下标??
                index = 2 * k +1;
            }else
                break;
        }
        arr[k] = temp;
    }

}
