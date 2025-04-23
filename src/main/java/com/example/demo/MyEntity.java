package com.example.demo;

import org.springframework.data.annotation.Id;

import java.util.Objects;

public class MyEntity {

    @Id
    Long Id; // primary key

    private String businessKey;
    private String field1;
    private String field2;
    private String field3;

//    @MappedCollection(idColumn = "my_entity_fk", keyColumn = "my_embedded_pk")
//    List<MyEmbedded> myEmbeddings;
//    @Embedded(onEmpty = USE_NULL)
//    MyEmbedded myEmbedding;

    public MyEntity(String businessKey, String field1, String field2, String field3) {

        this.businessKey = businessKey;
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;

    }

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MyEntity myEntity = (MyEntity) o;
        return Objects.equals(Id, myEntity.Id) && Objects.equals(businessKey, myEntity.businessKey) && Objects.equals(field1, myEntity.field1) && Objects.equals(field2, myEntity.field2) && Objects.equals(field3, myEntity.field3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, businessKey, field1, field2, field3);
    }

}
