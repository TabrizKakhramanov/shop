package org.skypro.skyshop.search;

public interface Searchable {
    String getSearchTerm();
    String getObjectType();
    String getObjectName();

    default public String getStringRepresentation(){
        return "имя объекта "+ getObjectName()+"- тип объекта " + getObjectType();
    }




}
