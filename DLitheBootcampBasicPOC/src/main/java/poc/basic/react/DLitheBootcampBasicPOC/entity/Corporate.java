package poc.basic.react.DLitheBootcampBasicPOC.entity;
import java.util.ArrayList;
import  java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity 
public class Corporate {
	// org, loactions, services, benchmarks, employees, basic
	
	@Id
	private String org;
	
	@ElementCollection
	private List<String> locations=new ArrayList<String>();
	@ElementCollection
	private List<String>services=new ArrayList<String>();
	@ElementCollection
	private List<String>benchmarks=new ArrayList<String>(); 
	
	private Integer employees;
	private Double basic;
	
	public String getOrg() {
		return org;
	}
	public void setOrg(String org) {
		this.org = org;
	}
	public List<String> getLocations() {
		return locations;
	}
	public void setLocations(List<String> locations) {
		this.locations = locations;
	}
	public List<String> getServices() {
		return services;
	}
	public void setServices(List<String> services) {
		this.services = services;
	}
	public List<String> getBenchmarks() {
		return benchmarks;
	}
	public void setBenchmarks(List<String> benchmarks) {
		this.benchmarks = benchmarks;
	}
	public Integer getEmployees() {
		return employees;
	}
	public void setEmployees(Integer employees) {
		this.employees = employees;
	}
	public Double getBasic() {
		return basic;
	}
	public void setBasic(Double basic) {
		this.basic = basic;
	}

}
