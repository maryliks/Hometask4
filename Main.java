package present;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        PresentForChildren presentForChildren = new PresentForChildren("input1.txt");
        System.out.println("Weight of present for children: " + presentForChildren.weightOfChildrenPresent());
        presentForChildren.output();
        System.out.println("\nSort by weight:");
        presentForChildren.printList(presentForChildren.sort());
        System.out.println("\nWhen sugar < 0.4: ");
        presentForChildren.printList(presentForChildren.sugarInPresent());
    }
}
