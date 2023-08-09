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
document.addEventListener('DOMContentLoaded', () => __awaiter(void 0, void 0, void 0, function* () {
    const taskListElement = document.getElementById('taskList');
    try {
        const response = yield fetch('/_apis/GetTasks');
        if (response.ok) {
            const tasks = yield response.json();
            tasks.forEach((task) => {
                console.log(task);
                const taskCard = document.createElement('div');
                taskCard.classList.add('taskCard');
                taskCard.innerHTML = `
                    <h3>${task.id}: ${task.title}</h3>
                    <p>Description: <span>${task.description}</span></p>
                    <p>Assign to: <span>${task.assignTo}</span></p>
                    <p>Creation Date: <span>${task.creationDate}</span></p>
                    <p>state: <span>${task.state}</span></p>
                `;
                taskListElement === null || taskListElement === void 0 ? void 0 : taskListElement.appendChild(taskCard);
            });
        }
        else {
            console.error('Error fetching tasks:', response.status);
            window.alert('Error fetching tasks:' + '\n' + response.status);
        }
    }
    catch (error) {
        console.error('Error fetching tasks:', error);
        window.alert('Error fetching tasks:' + '\n' + error);
    }
}));
