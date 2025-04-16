describe('Set Course Completion Deadlines', () => {
  const instructor = new InstructorPortal();
  const courseManagement = new CourseManagement();

  before(() => {
    instructor.login('INST9876', 'password123');
  });

  it('should navigate to Course Management section', () => {
    instructor.goToCourseManagement();
    courseManagement.verifyCourseListDisplayed();
  });

  it('should select course CSE101 to manage', () => {
    courseManagement.selectCourse('CSE101');
    courseManagement.verifyCourseDetailsDisplayed('CSE101');
  });

  it('should set assignment deadline', () => {
    courseManagement.goToDeadlinesTab();
    courseManagement.setAssignmentDeadline('2023-12-01');
    courseManagement.verifyAssignmentDeadline('2023-12-01');
  });

  it('should set quiz deadline', () => {
    courseManagement.setQuizDeadline('2023-12-05');
    courseManagement.verifyQuizDeadline('2023-12-05');
  });

  it('should set course completion deadline', () => {
    courseManagement.setCourseCompletionDeadline('2023-12-15');
    courseManagement.verifyCourseCompletionDeadline('2023-12-15');
  });

  it('should verify all deadlines in course overview', () => {
    courseManagement.verifyDeadlinesInOverview({
      assignment: '2023-12-01',
      quiz: '2023-12-05',
      completion: '2023-12-15'
    });
  });

  after(() => {
    instructor.logout();
  });
});