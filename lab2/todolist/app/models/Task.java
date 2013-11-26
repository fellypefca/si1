package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.Form;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Task extends Model {

	public static Finder<Long,Task> find = new Finder(Long.class, Task.class);
	
	@Id
	public Long id;
	
	public boolean done;

	@Required
	public String label;
	
	@Required
	public String description;
	
	@Required
	public int priority;

	public static List<Task> all() {
		List<Task> list = find.all();
		Comparator<Task> c = new Comparator<Task>() {
            @Override
            public int compare(Task arg0, Task arg1) {
                    return arg0.getPriority() - arg1.getPriority();
            }
		};
		Collections.sort(list, c);
		return list;		
	}

	public static void create(Task task) {
		task.save();
	}

	public static void delete(Long id) {
		find.ref(id).delete();
	}
	
	public  static void updateDone(Long id) {
		Task task = find.ref(id);
		task.setDone(true);
		task.update();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}
	
}