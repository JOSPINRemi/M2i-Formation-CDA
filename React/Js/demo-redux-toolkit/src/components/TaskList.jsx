import { useSelector } from "react-redux";
import TaskItem from "./TaskItem";

const TaskList = () => {
  const tasks = useSelector((state) => state.task.tasks);

  console.log(tasks);

  return (
    <>
      {tasks.map((task, key) => (
        <TaskItem key={key} task={task} />
      ))}
    </>
  );
};

export default TaskList;
