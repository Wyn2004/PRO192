
import java.util.*;
import java.io.*;

public class MyList {

    Node head, tail;
    int size;

    // Default constructor
    MyList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = head;
        while (p != null) {
            f.writeBytes(p.getInfo() + " "); // write data in the node p to the file f
            p = p.next;
        }

        f.writeBytes("\r\n");
    }

    /**
     * Do NOT modify this method Load 3 lines of data from file: line k (for
     * district), line k+1 (for price), and line k+2 (for area)
     *
     * @param k the k-th line where data is started to be loaded
     */
    void loadData(int k) {
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;

        for (int i = 0; i < n; i++) {
            addLast(a[i], b[i], c[i]);// insert the new Node(a[i], b[i], c[i]) into the list
        }
    }

    /**
     * Luy y: 1. SV KHONG su dung tieng Viet co dau trong bai lam de tranh Error
     * khi run chuong trinh. 2. Neu khong tuan thu se nhan diem 0 (khong).
     *
     * Question 1.1: implement the 'addLast' method that inserts a new Node into
     * the list's tail if the attributes 'price' and 'area' of an Apartment are
     * positive (>0). The output of this method will be written into the file
     * 'f1.txt'. Therefore you should open this file to see/test your code
     * output. Example: with the content given in the file 'data.txt', the
     * content of 'f1.txt' after insertion should be (Q1,9,8) (Q2,5,3) (Q4,6,5)
     * (Q9,1,1) (TD,7,9) (TB,4,7) (TD,2,2) (Q3,3,9)
     *
     * @param xDistrict the district of the input Apartment
     * @param xPrice the price (gia tien) of the input Apartment
     * @param xArea the area (dien tich) of the input Apartment
     */
    void addLast(String xDistrict, int xPrice, int xArea) {
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        if (xPrice <= 0 || xArea <= 0) {
            return;
        } else if (xPrice > 0 && xArea > 0) {
            Apartment info = new Apartment(xDistrict, xPrice, xArea);
            Node q = new Node(info);
            if (head == null) {
                head = tail = q;
            } else {
                tail.next = q;
                tail = q;
            }
        }
        size++;
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------

    }

    /**
     * Do NOT modify this method This is a helper method for writing data
     * (node's info) stored in the linked list to file
     *
     * @throws Exception
     */
    void f1() throws Exception {
        clear();
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        f.close();
    }

    // This method is used for Question 1.2
    void f2() throws Exception {
        clear();
        loadData(5);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");

        /**
         * Question 1.2: Update all nodes in the linked list with the
         * Apartment's district "Q2" or "Q9" to "TD", then increase the price by
         * 1.
         *
         * The output of this method will be written into the file 'f2.txt'.
         * Therefore you should open this file to see/test your code output.
         * Example: if the linked list before change is (Q1,9,8) (Q2,6,3)
         * (Q4,8,5) (Q9,5,4) (TD,4,9) then the content of 'f2.txt' after change
         * is (Q1,9,8) (TD,7,3) (Q4,8,5) (TD,6,4) (TD,4,9) the changed nodes
         * are: (Q2,6,3) and (Q9,5,4)
         */
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        Node p = head;
        while (p != null) {
            Apartment info = p.getInfo();
            String dis = info.getDistrict();
            if (dis.equals("Q2") || dis.equals("Q9")) {
                info.setDistrict("TD");
                info.setPrice(info.getPrice() + 1);
            }
            p = p.next;
        }
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    // This method is used for Question 1.3
    void f3() throws Exception {
        clear();
        loadData(9);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");

        /**
         * Question 1.3: Find the largest Apartment? If there are more than one
         * largest apartment, find the first of them.
         *
         * The output of this method will be written into the file 'f3.txt'.
         * Therefore you should open this file to see/test your code output.
         * Example: if the linked list is (Q1,9,18) (Q2,5,3) (Q4,6,5) (Q9,15,18)
         * (TD,7,9) (TB,4,7) (TD,3,2) (Q3,3,9) then the content of 'f3.txt' is
         * (Q1,9,18) The largest area is 18. There are two objects with this
         * value: (Q1,9,18) and (Q9,15,18); but we only find the first of them.
         */
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        Node p = head;
        int largestArea = head.getInfo().area;
        while (p != null) {
            Apartment info = p.getInfo();
            int area = info.getArea();
            //tim dien tich lon nhat
            if (largestArea < area) {
                largestArea = area;
            }
            //in ra vi tri
            if (largestArea == area) {
                //xoa ndung cua list
                head = tail = null;
                //them node largestArea
                addLast(info.getDistrict(), info.getPrice(), info.getArea());
                break;
            }
            p = p.next;
        }

        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    // This method is used for Question 1.4
    void f4() throws Exception {
        clear();
        loadData(13);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        /**
         * Question 1.4: Sort the linked list in an descending order according
         * to Apartment's price. The output of this method will be written into
         * the file 'f4.txt'. Therefore you should open this file to see/test
         * your code output. Example: if the linked list before sorting is
         * (Q1,9,18) (Q2,5,3) (Q4,6,5) (Q9,15,1) (TD,7,9) (TB,4,7) (TD,2,2)
         * (Q3,3,9) then the content of 'f4.txt' after sorting is (Q9,15,1)
         * (Q1,9,18) (TD,7,9) (Q4,6,5) (Q2,5,3) (TB,4,7) (Q3,3,9) (TD,2,2)
         */
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------

        for (int i = 0; i < size - 1; i++) {
            Node p = head;
            boolean sort = true;
            for (int j = 0; j < size - i - 1; j++) {
                Apartment a1 = p.getInfo();
                Apartment a2 = p.next.getInfo();
                int price1 = a1.getPrice();
                int price2 = a2.getPrice();
                //so sanh 
                if (price1 < price2) {
                    Apartment temp = a1;
                    p.setInfo(a2);
                    p.next.setInfo(temp);
                    //                    gan lai gia tri sort, tiet kiem thoi gian
                    sort = false;
                }
                p = p.next;
            }
            if (sort) {
                break;
            }
        }
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }
}
