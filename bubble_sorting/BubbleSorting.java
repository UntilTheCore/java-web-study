class BubbleSorting {
  public static void main(String[] args) {
	System.out.println("hello");
    int[] arr = {10, 20, 30, 70, 60, 50, 40 };

    System.out.println("排序前数组：" + java.util.Arrays.toString(arr));

    for (int i = 0; i < arr.length; i++) {
	  boolean flag = true;
	  // 减少不必要的循环
      for (int j = 0; j < arr.length - 1 - i; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j + 1];
          arr[j + 1] = arr[j];
          arr[j] = temp;
		  flag = false;
        }
      }
	  // 跳过不必要的循环
      if(flag) break;
	  System.out.println("排序中：" + java.util.Arrays.toString(arr));
    }
    System.out.println("排序前数组：" + java.util.Arrays.toString(arr));
  }
}