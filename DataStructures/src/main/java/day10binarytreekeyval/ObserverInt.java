package day10binarytreekeyval;

public interface ObserverInt<T> {

    public void added(T node);

    public void modified(T nodeOld, T nodeNew);

    public void deleted(T node);

}
