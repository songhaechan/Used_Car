package view.locator;
import java.util.Map;

//뷰를 할당하는 클래스
public class ViewLocator<T> {
    private final Map<Integer, T> views;

    public ViewLocator(Map<Integer, T> views) {
        this.views = views;
    }

    public T selectMenu(int menu){
        return views.get(menu);
    }
}
