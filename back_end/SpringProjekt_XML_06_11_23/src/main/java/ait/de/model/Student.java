package ait.de.model;

import java.util.Objects;

    public class Student {
        Long id;
        String firstName;
        String lastName;
        int year;
        String speciality;
        String cohort;

        public Student(Long id, String firstName, String lastName, int year, String speciality, String cohort) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.year = year;
            this.speciality = speciality;
            this.cohort = cohort;
        }

        public Student() {
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public String getSpeciality() {
            return speciality;
        }

        public void setSpeciality(String speciality) {
            this.speciality = speciality;
        }

        public String getCohort() {
            return cohort;
        }

        public void setCohort(String cohort) {
            this.cohort = cohort;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return Objects.equals(id, student.id) && Objects.equals(speciality, student.speciality) && Objects.equals(cohort, student.cohort);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, speciality, cohort);
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", year=" + year +
                    ", speciality='" + speciality + '\'' +
                    ", cohort='" + cohort + '\'' +
                    '}';
        }
    }


