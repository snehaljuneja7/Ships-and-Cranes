import java.util.Comparator;

class SortByID implements Comparator<Container>{
    public int compare(Container c1, Container c2){
        if(c1.getID().charAt(0) > c2.getID().charAt(0))
            return 1;
        else if(c1.getID().charAt(0) < c2.getID().charAt(0))
            return -1;
        else return 0;
    }
}