/* load projects */
insert into project (name, description, userId) values ('电动机单相全波整流能耗制动控制', '', 1);
insert into project (name, description, userId) values ('故障报警控制系统', '', 1);
insert into project (name, description, userId) values ('M7475型立轴圆台平面磨床控制', '', 1);
insert into project (name, description, userId) values ('project-4', '', 1);

/* load requirements */

/* load requirements of 电动机单相全波整流能耗制动控制 */
insert into requirement (text, project, error_description, state, disabled) values (
    'After 启动按钮按下 until (停止按钮按下 or 过载保护启动), 电动机启动 is true.',
    1,
    '',
    'COMPLIANT',
    false
);

insert into requirement (text, project, error_description, state, disabled) values (
    'After 停止按钮按下, delayL=0, delayR=30, 制动开关打开 is true.',
    1,
    '',
    'COMPLIANT',
    false
);

insert into requirement (text, project, error_description, state, disabled) values (
    'Globally, (电动机启动 and 制动开关打开) is false.',
    1,
    '',
    'COMPLIANT',
    false
);

/* load requirements of 故障报警控制系统 */
insert into requirement (text, project, error_description, state, disabled) values (
    'When (报警启动 and not M0.0), delayL=5, M0.1 is true.',
    2,
    '',
    'COMPLIANT',
    false
);

insert into requirement (text, project, error_description, state, disabled) values (
    'When (报警启动 and not M0.0), delayL=10, M0.0 is true.',
    2,
    '',
    'COMPLIANT',
    false
);

insert into requirement (text, project, error_description, state, disabled) values (
    'When M0.1, 报警灯亮 is true.',
    2,
    '',
    'COMPLIANT',
    false
);

insert into requirement (text, project, error_description, state, disabled) values (
    'After 响应按钮按下 until not 报警启动, 报警灯亮 is true.',
    2,
    '',
    'COMPLIANT',
    false
);

insert into requirement (text, project, error_description, state, disabled) values (
    'When 测试按钮按下, 报警灯亮 is true.',
    2,
    '',
    'COMPLIANT',
    false
);

insert into requirement (text, project, error_description, state, disabled) values (
    'When 报警启动, 蜂鸣器报警 is true.',
    2,
    '',
    'COMPLIANT',
    false
);

insert into requirement (text, project, error_description, state, disabled) values (
    'After 响应按钮按下 until not 报警启动, 蜂鸣器报警 is false.',
    2,
    '',
    'COMPLIANT',
    false
);

/* load requirements of M7475型立轴圆台平面磨床控制 */
insert into requirement (text, project, error_description, state, disabled) values (
    'After 总启动按钮按下 until (总停止按钮按下 or not 热继电器闭合), 电压继电器闭合 is true.',
    3,
    '',
    'COMPLIANT',
    false
);

insert into requirement (text, project, error_description, state, disabled) values (
    'After 砂轮电动机M1启动按钮按下 until (砂轮电动机M1停止按钮按下 or not 电压继电器闭合), 砂轮电动机M1接触器KM1闭合 is true.',
    3,
    '',
    'COMPLIANT',
    false
);

insert into requirement (text, project, error_description, state, disabled) values (
    'After 砂轮电动机M1启动按钮按下 until (砂轮电动机M1停止按钮按下 or not 电压继电器闭合), delayL = 0, delayR = 30, 砂轮电动机M1接触器KM3闭合 is true.',
    3,
    '',
    'COMPLIANT',
    false
);

insert into requirement (text, project, error_description, state, disabled) values (
    'After 砂轮电动机M1启动按钮按下 until (砂轮电动机M1停止按钮按下 or not 电压继电器闭合), delayL = 30, 砂轮电动机M1接触器KM2闭合 is true.',
    3,
    '',
    'COMPLIANT',
    false
);

insert into requirement (text, project, error_description, state, disabled) values (
    'Globally, (砂轮电动机M1接触器KM2闭合 and 砂轮电动机M1接触器KM3闭合) is false.',
    3,
    '',
    'COMPLIANT',
    false
);

insert into requirement (text, project, error_description, state, disabled) values (
    'When (电动机M2高速转换开关打开 and (not 砂轮升降电动机下降接触器闭合 and (not 中间继电器K2闭合 and 电压继电器闭合))), 工作台转动电动机高速接触器闭合 is true.',
    3,
    '',
    'COMPLIANT',
    false
);

insert into requirement (text, project, error_description, state, disabled) values (
    'When (电动机M2低速转换开关打开 and (not 砂轮升降电动机下降接触器闭合 and (not 中间继电器K2闭合 and 电压继电器闭合))), 工作台转动电动机低速接触器闭合 is true.',
    3,
    '',
    'COMPLIANT',
    false
);

insert into requirement (text, project, error_description, state, disabled) values (
    'Globally, (工作台转动电动机高速接触器闭合 and 工作台转动电动机低速接触器闭合) is false.',
    3,
    '',
    'COMPLIANT',
    false
);

insert into requirement (text, project, error_description, state, disabled) values (
    'When (电动机M3退出点动按钮按下 and (not 工作台退出限位行程开关打开 and 电压继电器闭合)), 工作台移动电动机正转接触器闭合 is true.',
    3,
    '',
    'COMPLIANT',
    false
);

insert into requirement (text, project, error_description, state, disabled) values (
    'When (电动机M3进入点动按钮按下 and (not 工作台进入限位行程开关打开 and 电压继电器闭合)), 工作台移动电动机反转接触器闭合 is true.',
    3,
    '',
    'COMPLIANT',
    false
);

insert into requirement (text, project, error_description, state, disabled) values (
    'Globally, (工作台移动电动机正转接触器闭合 and 工作台移动电动机反转接触器闭合) is false.',
    3,
    '',
    'COMPLIANT',
    false
);

insert into requirement (text, project, error_description, state, disabled) values (
    'When ((not 中间继电器K2闭合 or 砂轮升降电动机手动控制) and ((中间继电器K2闭合 or 中间继电器K1闭合) and (not 电动机M4（正转）上升点动按钮按下 and (not 砂轮升降上限位行程开关打开 and (not 冷却泵电动机接触器闭合 and (not M0.4 and 电压继电器闭合)))))), 砂轮升降电动机上升接触器闭合 is true.',
    3,
    '',
    'COMPLIANT',
    false
);

insert into requirement (text, project, error_description, state, disabled) values (
    'When (电动机M4（反转）下降点动按钮按下 and (not 自动进给电动机接触器闭合 and (not 砂轮升降电动机上升接触器闭合 and (not 工作台转动电动机低速接触器闭合 and (not 工作台转动电动机高速接触器闭合 and 电压继电器闭合))))), 砂轮升降电动机上升接触器闭合 is true.',
    3,
    '',
    'COMPLIANT',
    false
);

insert into requirement (text, project, error_description, state, disabled) values (
    'When (冷却泵电动机控制 and 电压继电器闭合), 冷却泵电动机接触器闭合 is true.',
    3,
    '',
    'COMPLIANT',
    false
);

insert into requirement (text, project, error_description, state, disabled) values (
    'After (总启动按钮按下 and 自动进给启动按钮按下) until (中间继电器K2闭合 or (自动进给限位行程开关打开 or 自动进给停止按钮按下)), delayL=0, delayRE=10, 自动进给电动机接触器闭合 is true.',
    3,
    '',
    'COMPLIANT',
    false
);

insert into requirement (text, project, error_description, state, disabled) values (
    'After (总启动按钮按下 and 自动进给启动按钮按下) until (中间继电器K2闭合 or (自动进给限位行程开关打开 or 自动进给停止按钮按下)), delayL=0, delayRE=10, 自动进给控制电磁铁 is true.',
    3,
    '',
    'COMPLIANT',
    false
);

insert into requirement (text, project, error_description, state, disabled) values (
    'When (not 电压继电器闭合 or 砂轮升降电动机上升接触器闭合), 自动进给电动机接触器闭合 is false.',
    3,
    '',
    'COMPLIANT',
    false
);

insert into requirement (text, project, error_description, state, disabled) values (
    'When (not 电压继电器闭合 or 砂轮升降电动机上升接触器闭合), 自动进给控制电磁铁 is false.',
    3,
    '',
    'COMPLIANT',
    false
);

insert into requirement (text, project, error_description, state, disabled) values (
    'When not 电磁吸盘欠电流控制, 中间继电器K2闭合 is true.',
    3,
    '',
    'COMPLIANT',
    false
);

insert into requirement (text, project, error_description, state, disabled) values (
    'When 电磁吸盘充磁可调控制, 电磁吸盘控制接触器闭合 is true.',
    3,
    '',
    'COMPLIANT',
    false
);

insert into requirement (text, project, error_description, state, disabled) values (
    'When 电磁吸盘控制接触器闭合, 中间继电器K1闭合 is true.',
    3,
    '',
    'COMPLIANT',
    false
);

insert into requirement (text, project, error_description, state, disabled) values (
    'When not 电磁吸盘控制接触器闭合, 中间继电器K3闭合 is true.',
    3,
    '',
    'COMPLIANT',
    false
);

insert into requirement (text, project, error_description, state, disabled) values (
    'When not 电磁吸盘控制接触器闭合, 中间继电器K3闭合 is true.',
    3,
    '',
    'COMPLIANT',
    false
);

/* load io-map */
insert into iomap (project_id, io_name, io_number) values (1, '启动按钮按下', 'I0.0');
insert into iomap (project_id, io_name, io_number) values (1, '停止按钮按下', 'I0.1');
insert into iomap (project_id, io_name, io_number) values (1, '过载保护启动', 'I0.2');
insert into iomap (project_id, io_name, io_number) values (1, '电动机启动', 'Q0.0');
insert into iomap (project_id, io_name, io_number) values (1, '制动开关打开', 'Q0.1');

insert into iomap (project_id, io_name, io_number) values (2, '报警启动', 'I0.0');
insert into iomap (project_id, io_name, io_number) values (2, '响应按钮按下', 'I0.1');
insert into iomap (project_id, io_name, io_number) values (2, '报警灯亮', 'Q0.0');
insert into iomap (project_id, io_name, io_number) values (2, '测试按钮按下', 'I0.2');
insert into iomap (project_id, io_name, io_number) values (2, '蜂鸣器报警', 'Q0.1');

insert into iomap (project_id, io_name, io_number) values (3, '热继电器闭合', 'I0.0');
insert into iomap (project_id, io_name, io_number) values (3, '总启动按钮按下', 'I0.1');
insert into iomap (project_id, io_name, io_number) values (3, '砂轮电动机M1启动按钮按下', 'I0.2');
insert into iomap (project_id, io_name, io_number) values (3, '砂轮电动机M1停止按钮按下', 'I0.3');
insert into iomap (project_id, io_name, io_number) values (3, '电动机M3退出点动按钮按下', 'I0.4');
insert into iomap (project_id, io_name, io_number) values (3, '电动机M3进入点动按钮按下', 'I0.5');
insert into iomap (project_id, io_name, io_number) values (3, '电动机M4（正转）上升点动按钮按下', 'I0.6');
insert into iomap (project_id, io_name, io_number) values (3, '电动机M4（反转）下降点动按钮按下', 'I0.7');
insert into iomap (project_id, io_name, io_number) values (3, '自动进给停止按钮按下', 'I1.0');
insert into iomap (project_id, io_name, io_number) values (3, '总停止按钮按下', 'I1.1');
insert into iomap (project_id, io_name, io_number) values (3, '电动机M2高速转换开关打开', 'I1.2');
insert into iomap (project_id, io_name, io_number) values (3, '电动机M2低速转换开关打开', 'I1.3');
insert into iomap (project_id, io_name, io_number) values (3, '自动进给启动按钮按下', 'I1.4');
insert into iomap (project_id, io_name, io_number) values (3, '电磁吸盘充磁可调控制', 'I1.5');
insert into iomap (project_id, io_name, io_number) values (3, '电磁吸盘充磁不可调控制', 'I1.6');
insert into iomap (project_id, io_name, io_number) values (3, '冷却泵电动机控制', 'I1.7');
insert into iomap (project_id, io_name, io_number) values (3, '砂轮升降电动机手动控制', 'I2.0');
insert into iomap (project_id, io_name, io_number) values (3, '自动进给控制', 'I2.1');
insert into iomap (project_id, io_name, io_number) values (3, '工作台退出限位行程开关打开', 'I2.2');
insert into iomap (project_id, io_name, io_number) values (3, '工作台进入限位行程开关打开', 'I2.3');
insert into iomap (project_id, io_name, io_number) values (3, '砂轮升降上限位行程开关打开', 'I2.4');
insert into iomap (project_id, io_name, io_number) values (3, '电动指示灯亮', 'Q0.0');
insert into iomap (project_id, io_name, io_number) values (3, '砂轮指示灯亮', 'Q0.1');
insert into iomap (project_id, io_name, io_number) values (3, '电压继电器闭合', 'Q0.2');
insert into iomap (project_id, io_name, io_number) values (3, '自动进给限位行程开关打开', 'I2.5');
insert into iomap (project_id, io_name, io_number) values (3, '电磁吸盘欠电流控制', 'I2.6');
insert into iomap (project_id, io_name, io_number) values (3, '砂轮电动机M1接触器KM1闭合', 'Q0.3');
insert into iomap (project_id, io_name, io_number) values (3, '砂轮电动机M1接触器KM2闭合', 'Q0.4');
insert into iomap (project_id, io_name, io_number) values (3, '砂轮电动机M1接触器KM3闭合', 'Q0.5');
insert into iomap (project_id, io_name, io_number) values (3, '工作台转动电动机低速接触器闭合', 'Q0.6');
insert into iomap (project_id, io_name, io_number) values (3, '工作台转动电动机高速接触器闭合', 'Q0.7');
insert into iomap (project_id, io_name, io_number) values (3, '工作台移动电动机正转接触器闭合', 'Q1.0');
insert into iomap (project_id, io_name, io_number) values (3, '工作台移动电动机反转接触器闭合', 'Q1.1');
insert into iomap (project_id, io_name, io_number) values (3, '砂轮升降电动机上升接触器闭合', 'Q1.2');
insert into iomap (project_id, io_name, io_number) values (3, '砂轮升降电动机下降接触器闭合', 'Q1.3');
insert into iomap (project_id, io_name, io_number) values (3, '冷却泵电动机接触器闭合', 'Q1.4');
insert into iomap (project_id, io_name, io_number) values (3, '自动进给电动机接触器闭合', 'Q1.5');
insert into iomap (project_id, io_name, io_number) values (3, '电磁吸盘控制接触器闭合', 'Q1.6');
insert into iomap (project_id, io_name, io_number) values (3, '自动进给控制电磁铁', 'Q1.7');
insert into iomap (project_id, io_name, io_number) values (3, '中间继电器K1闭合', 'Q2.0');
insert into iomap (project_id, io_name, io_number) values (3, '中间继电器K2闭合', 'Q2.1');
insert into iomap (project_id, io_name, io_number) values (3, '中间继电器K3闭合', 'Q2.2');
