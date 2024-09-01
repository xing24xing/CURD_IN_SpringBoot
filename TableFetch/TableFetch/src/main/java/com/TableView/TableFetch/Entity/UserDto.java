package com.TableView.TableFetch.Entity;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class UserDto {
 
	  @NotEmpty(message = "Fill The Whole Name")
	  private String name;
	  
	 
	@NotEmpty(message = "Fill The Email Correctly")
	  private String email;
	  
	  @NotEmpty(message = "Fill The Contact Number Correctly")
	  @Size(max = 10,message = "The Phone Must Be 10 Characters")
	  private String phone;
	  
	  @Min(value = 18,message ="Age Must Be At Least 18")
	  @Max(value = 100 ,message = "Age Must Be Less Than 100")
	  private int age;
	  public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

	  
	  
	  
}
