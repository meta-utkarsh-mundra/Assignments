package com.metacube.training.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.training.model.Employee;
import com.metacube.training.model.JobTitle;
import com.metacube.training.model.Project;
import com.metacube.training.model.Skill;
import com.metacube.training.service.interfaces.EmployeeService;
import com.metacube.training.service.interfaces.JobTitleService;
import com.metacube.training.service.interfaces.ProjectService;
import com.metacube.training.service.interfaces.SkillService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private ProjectService projectService;

	@Autowired
	private JobTitleService jobTitleService;

	@Autowired
	private SkillService skillService;

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/login")
	public String login() {
		return "admin/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam(name = "username") String username,
			@RequestParam(name = "password") String password) {

		return new ModelAndView("admin/dashboard", "username", username);

	}

	@RequestMapping(path = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "admin/login";
	}

	@RequestMapping(path = "/back", method = RequestMethod.GET)
	public String backToDashboard() {
		return "admin/dashboard";
	}

	@RequestMapping(path = "/projects", method = RequestMethod.GET)
	public String getAllprojects(Model model) {
		model.addAttribute("projects", projectService.getAllProjects());
		return "admin/projects";
	}

	@RequestMapping(path = "/projects/add", method = RequestMethod.GET)
	public String createproject(Model model) {
		model.addAttribute("project", new Project());
		return "admin/editProject";
	}

	@RequestMapping(path = "/projects", method = RequestMethod.POST)
	public String saveproject(@ModelAttribute("project") Project project) {
		if (project != null && project.getId() == null) {
			projectService.createProject(project);
		} else {
			projectService.updateProject(project);
		}
		return "redirect:/admin/projects";
	}

	@RequestMapping(path = "/projects/edit", method = RequestMethod.GET)
	public String editproject(Model model, @RequestParam("id") Long id) {
		model.addAttribute("project", projectService.getProjectById(id));
		return "admin/editProject";
	}

	@RequestMapping(path = "/projects/delete", method = RequestMethod.GET)
	public String deleteproject(@RequestParam("id") Long id) {
		projectService.deleteProject(id);
		return "redirect:/admin/projects";
	}

	/*
	 * Job Functionalities
	 */

	@RequestMapping(path = "/jobs/add", method = RequestMethod.GET)
	public String createjob(Model model) {
		model.addAttribute("job", new JobTitle());
		return "admin/editJob";
	}

	@RequestMapping(path = "/jobs", method = RequestMethod.POST)
	public String saveJob(@ModelAttribute("job") JobTitle jobTitle) {
		if (jobTitle != null && jobTitle.getId() == 0) {
			jobTitleService.createJobTitle(jobTitle);
		} else {
			jobTitleService.updateJobTitle(jobTitle);
		}
		return "redirect:/admin/jobs";
	}

	@RequestMapping(path = "/jobs", method = RequestMethod.GET)
	public String getAlljobs(Model model) {
		model.addAttribute("jobs", jobTitleService.getAllJobTitle());
		return "admin/jobs";
	}

	@RequestMapping(path = "/jobs/edit", method = RequestMethod.GET)
	public String editJob(Model model, @RequestParam("id") int id) {
		model.addAttribute("job", jobTitleService.getJobTitleById(id));
		return "admin/editjob";
	}

	@RequestMapping(path = "/jobs/delete", method = RequestMethod.GET)
	public String deleteJobTitle(@RequestParam("id") int id) {
		jobTitleService.deleteJobTitle(id);
		return "redirect:/admin/jobs";
	}

	/**
	 * code for skills start from here
	 */

	@RequestMapping(path = "/skills", method = RequestMethod.GET)
	public String getAllSkills(Model model) {
		model.addAttribute("skills", skillService.getAllSkills());
		return "admin/skills";
	}

	@RequestMapping(path = "/skills/add", method = RequestMethod.GET)
	public String createSkills(Model model) {
		model.addAttribute("skill", new Skill());
		return "admin/addSkill";
	}

	@RequestMapping(path = "/skills", method = RequestMethod.POST)
	public String saveSkill(@ModelAttribute("skill") Skill skill) {
		if (skill != null && skill.getId() == 0) {
			skillService.createSkill(skill);
		}
		return "redirect:/admin/skills";
	}

	/**
	 * code for employee
	 */

	@RequestMapping(path = "/employee", method = RequestMethod.GET)
	public String goToEmployeePage(Model model) {
		model.addAttribute("employee", new Employee());
		model.addAttribute("jobs", jobTitleService.getAllJobTitle());
		model.addAttribute("projects", projectService.getAllProjects());
		model.addAttribute("teamLeaders", employeeService.getTeamLeaders());
		model.addAttribute("managers", employeeService.getManagers());
		return "admin/addEmployee";
	}

	@RequestMapping(path = "/employee", method = RequestMethod.POST)
	public String addEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.createEmployee(employee);
		employeeService.addJobDetails(employee);
		return "/admin/dashboard";
	}

	@RequestMapping(path = "/searchEmployee", method = RequestMethod.GET)
	public String search(Model model) {
		return "admin/search";
	}

	@RequestMapping(path = "/searchEmployee", method = RequestMethod.POST)
	public String search(@RequestParam(name = "search") String searchString,
			Model model) {
		try {
			Employee employee = employeeService
					.getEmployeeByIdString(searchString);

			model.addAttribute("employees", employee);
			return "admin/profile";
		} catch (Exception e) {
			return "employee/error2";
		}
	}

}
