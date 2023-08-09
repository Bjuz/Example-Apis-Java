"use strict";
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
document.addEventListener('DOMContentLoaded', () => {
    const updateTaskForm = document.getElementById('updateTaskForm');
    updateTaskForm.addEventListener('submit', (event) => __awaiter(void 0, void 0, void 0, function* () {
        event.preventDefault();
        const taskId = document.getElementById('id').value;
        const title = document.getElementById('title').value;
        const description = document.getElementById('description').value;
        const assignTo = document.getElementById('assignTo').value;
        const newState = document.getElementById('newState').value;
        const updatedTask = {
            id: Number(taskId),
            title: title,
            description: description,
            assignTo: assignTo,
            state: newState
        };
        try {
            const response = yield fetch('/_apis/UpdateTask', {
                method: 'PATCH',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(updatedTask)
            });
            if (response.ok) {
                console.log('Task updated successfully');
            }
            else {
                console.error('Error updating task:', response.status);
            }
        }
        catch (error) {
            console.error('Error updating task:', error);
        }
    }));
});
