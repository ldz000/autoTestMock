package org.wsk.autoTestMock.entity;

public class UTest {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column u_test.id
     *
     * @mbg.generated Tue Mar 12 23:27:30 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column u_test.name
     *
     * @mbg.generated Tue Mar 12 23:27:30 CST 2019
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column u_test.age
     *
     * @mbg.generated Tue Mar 12 23:27:30 CST 2019
     */
    private Integer age;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column u_test.id
     *
     * @return the value of u_test.id
     *
     * @mbg.generated Tue Mar 12 23:27:30 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column u_test.id
     *
     * @param id the value for u_test.id
     *
     * @mbg.generated Tue Mar 12 23:27:30 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column u_test.name
     *
     * @return the value of u_test.name
     *
     * @mbg.generated Tue Mar 12 23:27:30 CST 2019
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column u_test.name
     *
     * @param name the value for u_test.name
     *
     * @mbg.generated Tue Mar 12 23:27:30 CST 2019
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column u_test.age
     *
     * @return the value of u_test.age
     *
     * @mbg.generated Tue Mar 12 23:27:30 CST 2019
     */
    public Integer getAge() {
        return age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column u_test.age
     *
     * @param age the value for u_test.age
     *
     * @mbg.generated Tue Mar 12 23:27:30 CST 2019
     */
    public void setAge(Integer age) {
        this.age = age;
    }
}