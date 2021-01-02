import java.util.Arrays;

public class Greed{
    public static int greedy(int[] dice){
        int score = 0;
        int counter = 1;
        Arrays.sort(dice);
        for(int i=1; i < dice.length; i++)
        {
            if(dice[i] != dice[i-1])
            {
                score += calc(dice[i-1], counter);
                counter = 1;
            }
            else  counter++;
        }
        score += calc(dice[dice.length-1], counter); // last throw
        return score;
    }

    private static int calc(int value, int counter) {
        int tmpValue=0;
        switch (value)
        {
            case 1: if(counter>=3)
                tmpValue = 1000;
                tmpValue += 100* (counter%3);
                return tmpValue;
            case 5: if(counter>=3)
                        tmpValue= 500;
                    tmpValue += 50* (counter%3);
                    return tmpValue;
            case 2: if(counter>=3) return 200; else return 0;
            case 3: if(counter>=3) return 300; else return 0;
            case 4: if(counter>=3) return 400; else return 0;
            case 6: if(counter>=3) return 600; else return 0;
            default: return 0;
        }
    }


}