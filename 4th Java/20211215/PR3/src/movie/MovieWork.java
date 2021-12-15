package movie;

public class MovieWork extends Movie {

    private final int[] score;

    public MovieWork(String title, int director, int actor, int ... score) {
        super(title, director, actor);
        this.score = score;
    }

    @Override
    public void display() { //여기를 구현하세요.
        int total = director + actor;
        String result = "";

        for (int i = 0; i < score.length; i++) {
            total += score[i];
        }

        System.out.printf("영화제목:%s\n", title);
        System.out.printf("감독:%d, 배우:%d\n", director, actor);
        System.out.printf("영화총점 :%d\n", total);

        if (total >= 15)
            result = "☆☆☆☆☆";
        else if (total >= 12)
            result = "☆☆☆☆";
        else if (total >= 10)
            result = "☆☆☆";
        else
            result = "☆☆";

        System.out.println("영화평점 : " + result);
    }

}
