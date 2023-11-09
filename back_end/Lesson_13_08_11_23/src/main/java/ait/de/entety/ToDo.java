package ait.de.entety;


import java.util.Objects;

public class ToDo {
    private Integer id;
    private Integer userId;
    private String description;
    private boolean isCompleted;

    public ToDo() {
    }

    public ToDo(Integer id, Integer userId, String description, boolean isCompleted) {
        this.id = id;
        this.userId = userId;
        this.description = description;
        this.isCompleted = isCompleted;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToDo toDo = (ToDo) o;
        return isCompleted == toDo.isCompleted && Objects.equals(id, toDo.id) && Objects.equals(userId, toDo.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, isCompleted);
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "id=" + id +
                ", userId=" + userId +
                ", description='" + description + '\'' +
                ", isCompleted=" + isCompleted +
                '}';
    }
}
