package lekasv.bek.service.impl;

import lekasv.bek.dto.taskBoard.CreateTaskBoardRequest;
import lekasv.bek.dto.taskBoard.TaskBoardProjectResponse;
import lekasv.bek.dto.taskBoard.TaskBoardResponse;
import lekasv.bek.dto.taskGroup.UpdateTaskGroupRequest;
import lekasv.bek.exception.extended.taskBoard.TaskBoardNotFoundException;
import lekasv.bek.mapper.TaskBoardMapper;
import lekasv.bek.model.TaskBoard;
import lekasv.bek.repository.TaskBoardRepository;
import lekasv.bek.service.api.TaskBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskBoardServiceImpl implements TaskBoardService {
    private final TaskBoardRepository taskBoardRepository;
    private final TaskBoardMapper taskBoardMapper;


    @Override
    public List<TaskBoardResponse> getAllTaskBoards() {
        return taskBoardRepository.findAll()
                .stream()
                .map(taskBoardMapper::toTaskBoardResponse)
                .toList();
    }

    @Override
    public List<TaskBoardProjectResponse> getByProjectId(Integer projectId) {
        return taskBoardRepository.findByProjectId(projectId)
                .stream()
                .map(taskBoardMapper::toTaskBoardProjectResponse)
                .toList();
    }

    @Override
    public TaskBoardResponse getByName(String name) {
        TaskBoard taskBoard = taskBoardRepository.findByName(name);
        return taskBoardMapper.toTaskBoardResponse(taskBoard);
    }

    @Override
    public TaskBoardResponse createTaskBoard(CreateTaskBoardRequest board) {
        TaskBoard taskBoard = taskBoardMapper.fromCreateTaskBoardRequest(board);
        taskBoardRepository.save(taskBoard);
        return taskBoardMapper.toTaskBoardResponse(taskBoard);
    }

    @Override
    public TaskBoardResponse updateTaskBoard(UpdateTaskGroupRequest board, Integer taskBoardId) {
        TaskBoard taskBoard = taskBoardRepository.findById(taskBoardId)
                .orElseThrow(TaskBoardNotFoundException::new);
        taskBoard.setName(board.getName());
        taskBoardRepository.save(taskBoard);
        return taskBoardMapper.toTaskBoardResponse(taskBoard);
    }

    @Override
    public void deleteTaskBoard(Integer taskBoardId) {
        taskBoardRepository.deleteById(taskBoardId);
    }
}
