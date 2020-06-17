package B6_DataStructuresAndAlgorithmBasic.ThucHanh.MyLinkedList;

public class TestMyLinkedList {
    public static void main(String[] args) {
        System.out.println("/=/=/=/= TESTING /=/=/=/=");
        MyLinkedList ll = new MyLinkedList(9);
        ll.addFirst(11);
//        ll.addFirst("ef");
//        ll.addFirst("gh");

        // 13 12 11 10

//        ll.add(4,"ij");
//        ll.add(4,"kl");
        ll.printList();

    }
}