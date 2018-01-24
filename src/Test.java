public class Test
{
    public static void main(String [] args)
    {
        Raquel r = new Raquel();

        String file = r.getCurrentFileAsString(
                "/home/castro/college/fourth_year/sem_1/CS401/blurbs/data/b3a27cbc90");

        System.out.println(file);
    }
//    for(int i = 0; i < 7; i++)
//    {
//        int x = 1;
//        cols[i] = stringFile.substring(
//                stringFile.indexOf(strCols[i]), stringFile.indexOf(i + x));
//
//        System.out.println(cols[3]);
//    }
}
