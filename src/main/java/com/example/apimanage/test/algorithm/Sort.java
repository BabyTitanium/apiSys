package com.example.apimanage.test.algorithm;

import java.util.Arrays;

public class Sort {
//    int[] array={1,45,4,2,5423,2,41,3,56342,123,1,5,856,2,9};

    //冒泡排序    适用于长度小
    public int[] maopao(int []array){
        int len=array.length;
        int [] arr=Arrays.copyOf(array,len);
        int temp;
        for(int i=1;i<len;i++){
            boolean flag=true;
            for(int j=0;j<len-i;j++){
                if(arr[j]>arr[j+1]){
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    flag=false;
                }
                if(flag){
                    break;
                }
            }
        }
        return arr;
    }

    //选择排序
    public int [] xuanze(int[] array){
        int len=array.length;
        int temp;
        int [] arr=Arrays.copyOf(array,len);
        for(int i=0;i<len-1;i++){
            int pos=i;
            for(int j=i+1;j<len;j++){
                if(arr[j]<arr[pos]){
                    pos=j;
                }
            }
            if(pos!=i){
                temp=arr[i];
                arr[i]=array[pos];
                array[pos]=temp;
            }
        }
        return  arr;
    }


    //插入排序
    public int [] charu(int[] array){
        int len=array.length;
        int temp;
        int [] arr=Arrays.copyOf(array,len);
        for(int i=1;i<len;i++){
            int j=i;
            temp=arr[i];
            while(j-1>=0&&arr[j-1]>temp){
                arr[j]=arr[j-1];
                j--;
            }
            if(j!=i){
                arr[j]=temp;
            }

        }
        return  arr;
    }

    //希尔排序
    public int [] sheel(int[] array){
        int len=array.length;
        int temp;
        int gap=len/2;
        int [] arr=Arrays.copyOf(array,len);
        while(gap>=1){
            for(int i=gap;i<len;i++){
                int j=i;
                temp=arr[j];
                while(j-gap>=0&&arr[j-gap]>temp){
                    arr[j]=arr[j-gap];
                    j=j-gap;
                }
                if(j!=i){
                    arr[j]=temp;
                }

            }
            gap=gap/2;
        }

        return  arr;
    }

    //快速排序   注意   初始right为len-1
    public void quickSort(int[] arr,int left,int right) {
        int i=left;
        int j=right;
        int temp=arr[i];
        int t;
        while(i!=j){
            while(j>i&&arr[j]>temp){
                j--;
            }
            while(j>i&&arr[i]<temp){
                i++;
            }
            if(i!=j){
                t=arr[i];
                arr[i]=arr[j];
                arr[j]=t;
            }
        }
        arr[left]=arr[i];
        arr[i]=temp;
        quickSort(arr,left,i-1);
        quickSort(arr,i+1,right);
    }
    //快速排序  优化
    public void quickSort1(int[] arr,int left,int right) {
        int i=left;
        int j=right;
        int temp=arr[left];
        while(left<right){
            while (right>left&&arr[right]>=temp){
                right--;
            }
            arr[left]=arr[right];
            while(left<right&&arr[left]<right){
                left++;
            }
            arr[right]=arr[left];
        }
        arr[left]=temp;
        quickSort1(arr,i,left-1);
        quickSort1(arr,left+1,j);
    }
    //堆排序
    public void heap(int[] arr) {
    }
}
