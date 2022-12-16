package javaTpoint.javacodes;

import java.util.Scanner;

// Java'da Min yığını oluşturmak için MinHeap sınıfı oluşturun
class MinHeap {
    // dizi ve değişkenleri bildirme
    public int[] heapData;
    private int sizeOfHeap;
    private int heapMaxSize;

    private static final int FRONT = 1;

    //heapData dizisini başlatmak için yapıcıyı kullanın
    public MinHeap(int heapMaxSize) {
        this.heapMaxSize = heapMaxSize;
        this.sizeOfHeap = 0;
        heapData = new int[this.heapMaxSize + 1];
        heapData[0] = Integer.MIN_VALUE;
    }

    // düğüm için ana konumu döndüren getParentPos() yöntemi oluşturun
    private int getParentPosition(int position) {
        return position / 2;
    }

    // sol çocuğun konumunu döndüren getLeftChildPosition() yöntemi oluşturun
    private int getLeftChildPosition(int position) {
        return (2 * position);
    }

    // sağ çocuğun konumunu döndüren getRightChildPosition() yöntemi oluşturun
    private int getRightChildPosition(int position) {
        return (2 * position) + 1;
    }

    // verilen düğümün yaprak olup olmadığını kontrol eder
    private boolean checkLeaf(int position) {
        if (position >= (sizeOfHeap / 2) && position <= sizeOfHeap) {
            return true;
        }
        return false;
    }

    // yığının verilen düğümlerinin takasını gerçekleştiren swapNode() yöntemi oluşturun
    // firstNode ve secondNode, düğümlerin konumlarıdır
    private void swap(int firstNode, int secondNode) {
        int temp;
        temp = heapData[firstNode];
        heapData[firstNode] = heapData[secondNode];
        heapData[secondNode] = temp;
    }

    // yığın özelliğini korumak ve düğümü yığın haline getirmek için minHeapify() yöntemi oluşturun
    private void minHeapify(int position) {

        //verilen düğümün yaprak olup olmadığını ve sağ ve sol alt öğesinden büyük olup olmadığını kontrol edin
        if (!checkLeaf(position)) {
            if (heapData[position] > heapData[getLeftChildPosition(position)] || heapData[position] > heapData[getRightChildPosition(position)]) {

                //sol çocukla değiş tokuş yapın ve sonra sol çocuğu yığınlaştırın
                if (heapData[getLeftChildPosition(position)] < heapData[getRightChildPosition(position)]) {
                    swap(position, getLeftChildPosition(position));
                    minHeapify(getLeftChildPosition(position));
                }

                // Doğru çocukla değiş tokuş yapın ve doğru çocuğu yığınlaştırın
                else {
                    swap(position, getRightChildPosition(position));
                    minHeapify(getRightChildPosition(position));
                }
            }
        }
    }

    // yığına öğe eklemek için insertNode() yöntemi oluşturun
    public void insertNode(int data) {
        if (sizeOfHeap >= heapMaxSize) {
            return;
        }
        heapData[++sizeOfHeap] = data;
        int current = sizeOfHeap;

        while (heapData[current] < heapData[getParentPosition(current)]) {
            swap(current, getParentPosition(current));
            current = getParentPosition(current);
        }
    }

    // yığının verilerini yazdırmak için crreatedisplayHeap() yöntemi
    public void displayHeap() {
        System.out.println("ana düğüm" + "\t" + "sol çocuk düğüm" + "\t\t" + "sağ çocuk düğüm");
        for (int k = 1; k <= sizeOfHeap / 2; k++) {
            System.out.print("\t " + heapData[k] + "\t\t\t\t" + heapData[2 * k] + "\t\t\t\t\t" + heapData[2 * k + 1]);
            System.out.println();
        }
    }

    // minimum yığın oluşturmak için designMinHeap() yöntemi oluşturun
    public void designMinHeap() {
        for (int position = (sizeOfHeap / 2); position >= 1; position--) {
            minHeapify(position);
        }
    }
}


// Java'da yığın oluşturmak için MinHeapJavaImplementation sınıfı oluşturun
class MinHeapJavaImplementation {


    public static void main(String[] arg) {
        // declare variable
        int heapSize;

        // tarayıcı sınıfı nesnesi oluştur
        Scanner sc = new Scanner(System.in);

        System.out.println("Min Yığın boyutunu girin");
        heapSize = sc.nextInt();

        MinHeap heapObj = new MinHeap(heapSize);

        for (int i = 1; i <= heapSize; i++) {
            System.out.print(+i + "." + " elementi gir: ");
            int data = sc.nextInt();
            heapObj.insertNode(data);
        }

        // tarayıcı sınıfı obj'yi kapat
        sc.close();

        //verilen verilerden bir min yığın oluşturma
        heapObj.designMinHeap();

        //minimum yığın verilerini göster
        System.out.println("Minimum Yığın ");
        heapObj.displayHeap();


    }
}