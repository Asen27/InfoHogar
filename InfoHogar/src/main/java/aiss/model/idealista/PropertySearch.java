
package aiss.model.idealista;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class PropertySearch {

    private List<ElementList> elementList = null;
    private Integer total;
    private Integer totalPages;
    private Integer actualPage;
    private Integer itemsPerPage;
    private Integer numPaginations;
    private List<String> summary = null;
    private Boolean paginable;
    private Integer upperRangePosition;
    private Integer lowerRangePosition;

    public List<ElementList> getElementList() {
        return elementList;
    }

    public void setElementList(List<ElementList> elementList) {
        this.elementList = elementList;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getActualPage() {
        return actualPage;
    }

    public void setActualPage(Integer actualPage) {
        this.actualPage = actualPage;
    }

    public Integer getItemsPerPage() {
        return itemsPerPage;
    }

    public void setItemsPerPage(Integer itemsPerPage) {
        this.itemsPerPage = itemsPerPage;
    }

    public Integer getNumPaginations() {
        return numPaginations;
    }

    public void setNumPaginations(Integer numPaginations) {
        this.numPaginations = numPaginations;
    }

    public List<String> getSummary() {
        return summary;
    }

    public void setSummary(List<String> summary) {
        this.summary = summary;
    }

    public Boolean getPaginable() {
        return paginable;
    }

    public void setPaginable(Boolean paginable) {
        this.paginable = paginable;
    }

    public Integer getUpperRangePosition() {
        return upperRangePosition;
    }

    public void setUpperRangePosition(Integer upperRangePosition) {
        this.upperRangePosition = upperRangePosition;
    }

    public Integer getLowerRangePosition() {
        return lowerRangePosition;
    }

    public void setLowerRangePosition(Integer lowerRangePosition) {
        this.lowerRangePosition = lowerRangePosition;
    }

}
