/**
 * Created by jjrobertson on 23/01/17.
 */
public class magicSquare {
    public void findSquare() {
        for (int a = 1; a <= 20; a++) {
            for (int b = 1; b <= 20; b++) {
                for (int c = 1; c <= 20; c++) {
                    for (int d = 1; d <= 20; d++) {
                        for (int e = 1; e <= 20; e++) {
                            for (int f = 1; f <= 20; f++) {
                                for (int g = 1; g <= 20; g++) {
                                    for (int h = 1; h <= 20; h++) {
                                        for (int i = 1; i <= 20; e++) {
                                            //rows
                                            int sum = a + b + c;
                                            if (d + e + f != sum)
                                                break;
                                            if (g + h + i != sum)
                                                break;
                                            //cols
                                            if (a + d + g != sum)
                                                break;
                                            if (b + e + h != sum)
                                                break;
                                            if (c + f + i != sum)
                                                break;
                                            //diags
                                            if (a + e + i != sum)
                                                break;
                                            if (c + e + g != sum)
                                                break;

                                            System.out.print(a + " " + b + " " + c + "\n");
                                            System.out.print(d + " " + e + " " + f + "\n");
                                            System.out.print(g + " " + h + " " + i + "\n");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
