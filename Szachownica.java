import java.util.Scanner;
import static java.lang.Math.abs;

public class Szachownica
{
    public static int parserInt(String number)
    {
        int result = 101;

        try {
            result = Integer.parseInt (number);
        } catch(NumberFormatException e) {
            System.out.println ("Podano nieliczbową wartosc");
            System.exit(0);
        }

        if (result < 1 || result > 15) {
            System.out.println("Podana wartosc jest za duza lub za mała");
            System.exit(0);
        }

        return result;
    }
    public static void main (String[] args)
    {
        System.out.println ("Podaj dlugosci bokow rownolegloboku i kat: ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println("wczytano: " + str + ".");
        System.out.println("dlugosc str: " + str.length());

        String tabString[] = str.split(" ");

        System.out.println("rozmiar tablicy: " + tabString.length);

        if (tabString.length != 6)
        {
            System.out.println("Niewlasciwa ilosc elementów");
            System.exit(0);
        }

        int width, height, quantityHorizontal, quantityVertical; //szerokosc, wysokosc, ilość w poziomie, ilość w pionie
        char white, black;

        width = parserInt(tabString[0]);
        height = parserInt(tabString[1]);
        quantityHorizontal = parserInt(tabString[2]);
        quantityVertical = parserInt(tabString[3]);

        //---------------------------------------------------------------klasa szachownica
        System.out.println(width + " - szerokosc\n" + height + " - wysokosc");
        System.out.println(width + " " + height + " " + angle);

        String verse = "";
        for (int i = 0; i < width; i++)
        {
            verse += "*";
        }

        if (angle == 0 || height == 1) //prostokat
        {
            for (int i = 0; i < height - 1; i++)
            {
                System.out.println(verse);
            }
            System.out.println(verse + "\n"); //ostatnia linijka poza petla bo ze znakiem konca linii
        }
        else //rownoleglobok
        {
            String space = "";
            for (int i = 0; i < abs(angle); i++)
            {
                space += " ";
            }

            if (angle > 0)
            {
                for (int i = 0; i < height - 1; i++)
                {
                    System.out.println(verse);
                    verse = space + verse;
                }
                System.out.println(verse + "\n"); //ostatnia linijka poza petla bo ze znakiem konca linii
            }
            else //angle < 0
            {
                String allSpace = space;
                for (int i = 0; i < height - 2; i++)
                {
                    allSpace += space;
                }

                verse = allSpace + verse;
                for (int i = 0; i < height; i++)
                {
                    System.out.println(verse);
                    verse = verse.substring(abs(angle));
                }
                //System.out.println(verse + "\n"); //ostatnia linijka poza petla bo ze znakiem konca linii
            }
        }
    }
}


/*
slownik:
szerokosc      - width
wysokosc       - height
kąt nachylenia - slope angle
wiersz         - verse
*/