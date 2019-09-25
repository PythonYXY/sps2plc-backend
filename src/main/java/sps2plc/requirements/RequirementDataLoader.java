package sps2plc.requirements;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Order(2)
public class RequirementDataLoader implements CommandLineRunner {

    private RequirementRepository requirementRepository;

    @Autowired
    public RequirementDataLoader(RequirementRepository requirementRepository) {
        this.requirementRepository = requirementRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        // 电动机单相全波整流能耗制动控制
        log.info("Preloading " + this.requirementRepository.save(new Requirement("After 启动按钮按下 until (停止按钮按下 or 过载保护启动), 电动机启动 is true.",
                Long.parseLong("1"), "", Requirement.ReqState.COMPLIANT, false)));
        log.info("Preloading " + this.requirementRepository.save(new Requirement("After 停止按钮按下, delayL=0, delayR=30, 制动开关打开 is true.",
                Long.parseLong("1"), "", Requirement.ReqState.COMPLIANT, false)));
        log.info("Preloading " + this.requirementRepository.save(new Requirement("When 电动机启动, 制动开关打开 is false.",
                Long.parseLong("1"), "", Requirement.ReqState.COMPLIANT, false)));

        // 故障报警控制系统
        log.info("Preloading " + this.requirementRepository.save(new Requirement("When (报警启动 and not M0.0), delayL=5, M0.1 is true.",
                Long.parseLong("2"), "", Requirement.ReqState.COMPLIANT, false)));
        log.info("Preloading " + this.requirementRepository.save(new Requirement("When (报警启动 and not M0.0), delayL=10, M0.0 is true.",
                Long.parseLong("2"), "", Requirement.ReqState.COMPLIANT, false)));
        log.info("Preloading " + this.requirementRepository.save(new Requirement("When M0.1, 报警灯亮 is true.",
                Long.parseLong("2"), "", Requirement.ReqState.COMPLIANT, false)));
        log.info("Preloading " + this.requirementRepository.save(new Requirement("After 响应按钮按下 until not 报警启动, 报警灯亮 is true.",
                Long.parseLong("2"), "", Requirement.ReqState.COMPLIANT, false)));
        log.info("Preloading " + this.requirementRepository.save(new Requirement("When 测试按钮按下, 报警灯亮 is true.",
                Long.parseLong("2"), "", Requirement.ReqState.COMPLIANT, false)));
        log.info("Preloading " + this.requirementRepository.save(new Requirement("When 报警启动, 蜂鸣器报警 is true.",
                Long.parseLong("2"), "", Requirement.ReqState.COMPLIANT, false)));
        log.info("Preloading " + this.requirementRepository.save(new Requirement("After 响应按钮按下 until not 报警启动, 蜂鸣器报警 is false.",
                Long.parseLong("2"), "", Requirement.ReqState.COMPLIANT, false)));


        // M7475型立轴圆台平面磨床控制
        log.info("Preloading " + this.requirementRepository.save(new Requirement("After 总启动按钮按下 until (总停止按钮按下 or not 热继电器闭合), 电压继电器闭合 is true.",
                Long.parseLong("3"), "", Requirement.ReqState.COMPLIANT, false)));
        log.info("Preloading " + this.requirementRepository.save(new Requirement("After 砂轮电动机M1启动按钮按下 until (砂轮电动机M1停止按钮按下 or not 电压继电器闭合), 砂轮电动机M1接触器KM1闭合 is true.",
                Long.parseLong("3"), "", Requirement.ReqState.COMPLIANT, false)));
        log.info("Preloading " + this.requirementRepository.save(new Requirement("After 砂轮电动机M1启动按钮按下 until ((砂轮电动机M1停止按钮按下 or 砂轮电动机M1接触器KM2闭合) or not 热继电器闭合), delayL = 0, delayR = 30, 砂轮电动机M1接触器KM3闭合 is true.",
                Long.parseLong("3"), "", Requirement.ReqState.COMPLIANT, false)));
        log.info("Preloading " + this.requirementRepository.save(new Requirement("After 砂轮电动机M1启动按钮按下 until (砂轮电动机M1停止按钮按下 or not 电压继电器闭合), delayL = 30, 砂轮电动机M1接触器KM2闭合 is true.",
                Long.parseLong("3"), "", Requirement.ReqState.COMPLIANT, false)));
        log.info("Preloading " + this.requirementRepository.save(new Requirement("After 砂轮电动机M1启动按钮按下 until ((砂轮电动机M1停止按钮按下 or 砂轮电动机M1接触器KM2闭合) or not 热继电器闭合), delayL = 0, delayR = 30, 砂轮电动机M1接触器KM2闭合 is false.",
                Long.parseLong("3"), "", Requirement.ReqState.COMPLIANT, false)));

        log.info("Preloading " + this.requirementRepository.save(new Requirement("When (not 中间继电器K2闭合 and (not 砂轮升降电动机下降接触器闭合 and (电动机M2高速转换开关打开 and 电压继电器闭合))), 工作台转动电动机高速接触器闭合 is true.",
                Long.parseLong("3"), "", Requirement.ReqState.COMPLIANT, false)));
        log.info("Preloading " + this.requirementRepository.save(new Requirement("When (not 中间继电器K2闭合 and (not 砂轮升降电动机下降接触器闭合 and (电动机M2低速转换开关打开 and 电压继电器闭合))), 工作台转动电动机低速接触器闭合 is true.",
                Long.parseLong("3"), "", Requirement.ReqState.COMPLIANT, false)));
        log.info("Preloading " + this.requirementRepository.save(new Requirement("When (not 中间继电器K2闭合 and (not 砂轮升降电动机下降接触器闭合 and (电动机M2高速转换开关打开 and 电压继电器闭合))), 工作台转动电动机低速接触器闭合 is false.",
                Long.parseLong("3"), "", Requirement.ReqState.COMPLIANT, false)));
        log.info("Preloading " + this.requirementRepository.save(new Requirement("When (not 中间继电器K2闭合 and (not 砂轮升降电动机下降接触器闭合 and (电动机M2低速转换开关打开 and 电压继电器闭合))), 工作台转动电动机高速接触器闭合 is false.",
                Long.parseLong("3"), "", Requirement.ReqState.COMPLIANT, false)));

        log.info("Preloading " + this.requirementRepository.save(new Requirement("When (电动机M3退出点动按钮按下 and (not 工作台退出限位行程开关打开 and 电压继电器闭合)), 工作台移动电动机正转接触器闭合 is true.",
                Long.parseLong("3"), "", Requirement.ReqState.COMPLIANT, false)));
        log.info("Preloading " + this.requirementRepository.save(new Requirement("When (电动机M3进入点动按钮按下 and (not 工作台进入限位行程开关打开 and 电压继电器闭合)), 工作台移动电动机反转接触器闭合 is true.",
                Long.parseLong("3"), "", Requirement.ReqState.COMPLIANT, false)));
        log.info("Preloading " + this.requirementRepository.save(new Requirement("When (电动机M3退出点动按钮按下 and (not 工作台退出限位行程开关打开 and 电压继电器闭合)), 工作台移动电动机反转接触器闭合 is false.",
                Long.parseLong("3"), "", Requirement.ReqState.COMPLIANT, false)));
        log.info("Preloading " + this.requirementRepository.save(new Requirement("When (电动机M3进入点动按钮按下 and (not 工作台进入限位行程开关打开 and 电压继电器闭合)), 工作台移动电动机正转接触器闭合 is false.",
                Long.parseLong("3"), "", Requirement.ReqState.COMPLIANT, false)));

        log.info("Preloading " + this.requirementRepository.save(new Requirement("When ((not 中间继电器K2闭合 or 砂轮升降电动机手动控制) and ((\n" +
                "中间继电器K2闭合 or 中间继电器K1闭合) and (not 电动机M4（正转）上升点动按钮按下 and (not 砂轮升降上限位行程开关打开 and (not 冷却泵电动机接触器闭合 and (not M0.4 and 电压继电器闭合)))))), 砂轮升降电动机上升接触器闭合 is true.",
                Long.parseLong("3"), "", Requirement.ReqState.COMPLIANT, false)));
        log.info("Preloading " + this.requirementRepository.save(new Requirement("When (电动机M4（反转）下降点动按钮按下 and (not 自动进给电动机接触器闭合 and (not 砂轮升降电动机上升接触器闭合 and (not 工作台转动电动机低速接触器闭合 and (not 工作台转动电动机高速接触器闭合 and 电压继电器闭合))))), 砂轮升降电动机上升接触器闭合 is true.",
                Long.parseLong("3"), "", Requirement.ReqState.COMPLIANT, true)));
        log.info("Preloading " + this.requirementRepository.save(new Requirement("When (冷却泵电动机控制 and 电压继电器闭合), 冷却泵电动机接触器闭合 is true.",
                Long.parseLong("3"), "", Requirement.ReqState.COMPLIANT, false)));
        log.info("Preloading " + this.requirementRepository.save(new Requirement("After (总启动按钮按下 and 自动进给启动按钮按下) until (中间继电器K2闭合 or (自动进给限位行程开关打开 or 自动进给停止按钮按下)), delayL=0, delayRE=10, 自动进给电动机接触器闭合 is true.",
                Long.parseLong("3"), "", Requirement.ReqState.COMPLIANT, false)));
        log.info("Preloading " + this.requirementRepository.save(new Requirement("After (总启动按钮按下 and 自动进给启动按钮按下) until (中间继电器K2闭合 or (自动进给限位行程开关打开 or 自动进给停止按钮按下)), delayL=0, delayRE=10, 自动进给控制电磁铁 is true.",
                Long.parseLong("3"), "", Requirement.ReqState.COMPLIANT, false)));
        log.info("Preloading " + this.requirementRepository.save(new Requirement("When (not 电压继电器闭合 or 砂轮升降电动机上升接触器闭合), 自动进给电动机接触器闭合 is false.",
                Long.parseLong("3"), "", Requirement.ReqState.COMPLIANT, false)));
        log.info("Preloading " + this.requirementRepository.save(new Requirement("When (not 电压继电器闭合 or 砂轮升降电动机上升接触器闭合), 自动进给控制电磁铁 is false.",
                Long.parseLong("3"), "", Requirement.ReqState.COMPLIANT, false)));

        log.info("Preloading " + this.requirementRepository.save(new Requirement("When 电磁吸盘欠电流控制, 中间继电器K2闭合 is false.",
                Long.parseLong("3"), "", Requirement.ReqState.COMPLIANT, false)));
        log.info("Preloading " + this.requirementRepository.save(new Requirement("When 电磁吸盘充磁可调控制, 电磁吸盘控制接触器闭合 is true.",
                Long.parseLong("3"), "", Requirement.ReqState.COMPLIANT, false)));
        log.info("Preloading " + this.requirementRepository.save(new Requirement("When 电磁吸盘控制接触器闭合, 中间继电器K1闭合 is true.",
                Long.parseLong("3"), "", Requirement.ReqState.COMPLIANT, false)));
        log.info("Preloading " + this.requirementRepository.save(new Requirement("When 电磁吸盘控制接触器闭合, 中间继电器K3闭合 is false.",
                Long.parseLong("3"), "", Requirement.ReqState.COMPLIANT, false)));

//        log.info("Preloading " + this.requirementRepository.save(new Requirement("When not 电磁吸盘控制接触器闭合, 中间继电器K3闭合 is true.",
//                Long.parseLong("3"), "", Requirement.ReqState.COMPLIANT, false)));


        // project-4
        log.info("Preloading " + this.requirementRepository.save(new Requirement("When (I0.0 and not M0.0), delayL=5, M0.1 is true.",
                Long.parseLong("4"), "", Requirement.ReqState.COMPLIANT, false)));
//        log.info("Preloading " + this.requirementRepository.save(new Requirement("When M0.1, delayL=5, M0.0 is true.",
//                Long.parseLong("4"), "", Requirement.ReqState.COMPLIANT, false)));
        log.info("Preloading " + this.requirementRepository.save(new Requirement("When (I0.0 and not M0.0), delayL=10, M0.0 is true.",
                Long.parseLong("4"), "", Requirement.ReqState.COMPLIANT, false)));
        log.info("Preloading " + this.requirementRepository.save(new Requirement("When M0.1, Q0.0 is true.",
                Long.parseLong("4"), "", Requirement.ReqState.COMPLIANT, false)));
        log.info("Preloading " + this.requirementRepository.save(new Requirement("After I0.1 until not I0.0, Q0.0 is true.",
                Long.parseLong("4"), "", Requirement.ReqState.COMPLIANT, false)));
        log.info("Preloading " + this.requirementRepository.save(new Requirement("When I0.2, Q0.0 is true.",
                Long.parseLong("4"), "", Requirement.ReqState.COMPLIANT, false)));
        log.info("Preloading " + this.requirementRepository.save(new Requirement("When I0.0, Q0.1 is true.",
                Long.parseLong("4"), "", Requirement.ReqState.COMPLIANT, false)));
        log.info("Preloading " + this.requirementRepository.save(new Requirement("After I0.1 until not I0.0, Q0.1 is false.",
                Long.parseLong("4"), "", Requirement.ReqState.COMPLIANT, false)));


    }
}