
package aiss.model.idealista;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ElementList {

    private String propertyCode;
    private String thumbnail;
    private Integer numPhotos;
    private String floor;
    private Integer price;
    private String propertyType;
    private String operation;
    private Integer size;
    private Boolean exterior;
    private Integer rooms;
    private Integer bathrooms;
    private String address;
    private String province;
    private String municipality;
    private String district;
    private String neighborhood;
    private String country;
    private Double latitude;
    private Double longitude;
    private Boolean showAddress;
    private String url;
    private Boolean agency;
    private Boolean favourite;
    private Boolean hasVideo;
    private String status;
    private String age;
    private Boolean newDevelopment;
    private Boolean newProperty;

    public String getPropertyCode() {
        return propertyCode;
    }

    public void setPropertyCode(String propertyCode) {
        this.propertyCode = propertyCode;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Integer getNumPhotos() {
        return numPhotos;
    }

    public void setNumPhotos(Integer numPhotos) {
        this.numPhotos = numPhotos;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Boolean getExterior() {
        return exterior;
    }

    public void setExterior(Boolean exterior) {
        this.exterior = exterior;
    }

    public Integer getRooms() {
        return rooms;
    }

    public void setRooms(Integer rooms) {
        this.rooms = rooms;
    }

    public Integer getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(Integer bathrooms) {
        this.bathrooms = bathrooms;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Boolean getShowAddress() {
        return showAddress;
    }

    public void setShowAddress(Boolean showAddress) {
        this.showAddress = showAddress;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getAgency() {
        return agency;
    }

    public void setAgency(Boolean agency) {
        this.agency = agency;
    }

    public Boolean getFavourite() {
        return favourite;
    }

    public void setFavourite(Boolean favourite) {
        this.favourite = favourite;
    }

    public Boolean getHasVideo() {
        return hasVideo;
    }

    public void setHasVideo(Boolean hasVideo) {
        this.hasVideo = hasVideo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Boolean getNewDevelopment() {
        return newDevelopment;
    }

    public void setNewDevelopment(Boolean newDevelopment) {
        this.newDevelopment = newDevelopment;
    }

    public Boolean getNewProperty() {
        return newProperty;
    }

    public void setNewProperty(Boolean newProperty) {
        this.newProperty = newProperty;
    }

}
