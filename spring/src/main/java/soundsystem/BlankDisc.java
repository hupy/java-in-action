package soundsystem;

/**
 * @author xingoo
 */
public class BlankDisc implements CompactDisc {
    private String title;
    private String artist
            ;
    BlankDisc(String title, String artist){
        this.title = title;
        this.artist = artist;
    }

    @Override
    public void play() {
        System.out.println(title+artist);
    }
}
