package player;

/**
 * BasePlayer is an abstract base class.
 *
 * A BasePlayer object encapsulates the state information needed for a player that the BattleShip
 * Board Game may support.
 */
public abstract class BasePlayer {

//Variable(s)-
   private int score;
   private int hits;
   private int misses;

//Constructor(s)-
    /**
     * Package Private Constructor, Initializes class fields.
     */
    BasePlayer() { score = 0; hits = 0; misses = 0; }

//Package Private Method(s)-
    /**
     * Will add to the current score value.
     *
     * @param score amount to be added to current score value.
     */
    void addToScore(int score) { this.score += score; }

    /**
     * Will add to the current amount of hits.
     *
     * @param hit amount to be added to current hit value.
     */
    void addToHits(int hit) { this.hits += hit; }

    /**
     * Will add to the current amount of misses.
     *
     * @param miss amount to be added to current miss value.
     */
    void addToMisses(int miss) { this.misses += miss; }

//Public Abstract Method(s)-
    /**
     * Abstract method that the extending class must implement.
     */
    public abstract void turnLoop ();

//Public Overridden Method(s)-
    /**
     * Returns a string that "textually represents" this object.
     *
     * @return string representation of the this object.
     */
    @Override
    public String toString() { return String.format("%nBasePlayer Score: %s, Hits: $s, Misses: $s, Shots Fired: %s",
            this.score, this.hits, this.misses, this.getShotsFiredCount()); }

//Getters(s)-
    /**
     * Getter for "this" objects score.
     *
     * @return "this" objects score.
     */
    public int getScore() { return this.score; }

    /**
     * Getter for "this" objects hit count.
     *
     * @return "this" objects hit count.
     */
    public int getHitCount() { return this.hits; }

    /**
     * Getter for "this" objects miss count.
     *
     * @return "this" objects miss count.
     */
    public int getMissCount() { return this.misses; }

    /**
     * Getter for "this" objects sum of hit and miss count
     *
     * @return sum of "this" objects hit and miss count.
     */
    public int getShotsFiredCount() { return (this.misses + this.hits); }

}//End of Class.
