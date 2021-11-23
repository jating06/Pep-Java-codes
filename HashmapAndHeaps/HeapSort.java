class HeapSort {
    public static void swap(int x, int y, int arr[]) { // O(1)

        int ele1 = arr[x];
        int ele2 = arr[y];

        arr[x] = ele2;
        arr[y] = ele1;
    }
    public static void downHeapify(int pi, int n, int arr[]) {
        int lci = pi * 2 + 1;
        int rci = pi * 2 + 2;
        int wrongIdx = pi;
        if (lci < n && arr[lci] > arr[wrongIdx]) {
            wrongIdx = lci;
        }
        if (rci < n && arr[rci] > arr[wrongIdx]) {
            wrongIdx = rci;
        }
        if (wrongIdx != pi) {
            swap(wrongIdx, pi, arr);
            downHeapify(wrongIdx, n, arr);
        }
    }
    public static void heapSort(int arr[]) {
        int n = arr.length;
        for (int i = n - 1; i >= 0; i--)
            downHeapify(i, n, arr);


        while (n != 0) {
            swap(0, n - 1, arr);
            n--;
            downHeapify(0, n, arr);


        }
    }
    public static void main(String args[]) {
        int arr []= {5,4,3,2,1};
        heapSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}