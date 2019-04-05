package ng.com.silveredgeprojects.nearbyshop.ModelEndPoints;

import org.nearbyshops.enduserappnew.Model.Item;

import java.util.List;

/**
 * Created by sumeet on 30/6/16.
 */
public class ItemEndPoint {

    private int itemCount;
    private int offset;
    private int limit;
    private List<Item> results;


    public Integer getItemCount() {
        return itemCount;
    }

    public void setItemCount(Integer itemCount) {
        this.itemCount = itemCount;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }


    public List<Item> getResults() {
        return results;
    }

    public void setResults(List<Item> results) {
        this.results = results;
    }
}
