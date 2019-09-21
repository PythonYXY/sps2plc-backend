package sps2plc.ioTable;


import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@Order(3)
public class IOTableDataLoader implements CommandLineRunner {

    private IOTableRepository ioTableRepository;

    @Autowired
    public IOTableDataLoader(IOTableRepository ioTableRepository) {
        this.ioTableRepository = ioTableRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Preloading " + this.ioTableRepository.save(new IOMap(Long.parseLong("1"), "启动按钮按下", "I0.0")));
        log.info("Preloading " + this.ioTableRepository.save(new IOMap(Long.parseLong("1"), "停止按钮按下", "I0.1")));
        log.info("Preloading " + this.ioTableRepository.save(new IOMap(Long.parseLong("1"), "过载保护启动", "I0.2")));
        log.info("Preloading " + this.ioTableRepository.save(new IOMap(Long.parseLong("1"), "电动机启动", "Q0.0")));
        log.info("Preloading " + this.ioTableRepository.save(new IOMap(Long.parseLong("1"), "制动开关打开", "Q0.1")));


        log.info("Preloading " + this.ioTableRepository.save(new IOMap(Long.parseLong("2"), "报警启动", "I0.0")));
        log.info("Preloading " + this.ioTableRepository.save(new IOMap(Long.parseLong("2"), "响应按钮按下", "I0.1")));
        log.info("Preloading " + this.ioTableRepository.save(new IOMap(Long.parseLong("2"), "报警灯亮", "Q0.0")));
        log.info("Preloading " + this.ioTableRepository.save(new IOMap(Long.parseLong("2"), "测试按钮按下", "I0.2")));
        log.info("Preloading " + this.ioTableRepository.save(new IOMap(Long.parseLong("2"), "蜂鸣器报警", "Q0.1")));

        log.info("Preloading " + this.ioTableRepository.save(new IOMap(Long.parseLong("3"), "热继电器闭合", "I0.0")));
        log.info("Preloading " + this.ioTableRepository.save(new IOMap(Long.parseLong("3"), "总启动按钮按下", "I0.1")));
        log.info("Preloading " + this.ioTableRepository.save(new IOMap(Long.parseLong("3"), "砂轮电动机M1启动按钮按下", "I0.2")));
        log.info("Preloading " + this.ioTableRepository.save(new IOMap(Long.parseLong("3"), "砂轮电动机M1停止按钮按下", "I0.3")));
        log.info("Preloading " + this.ioTableRepository.save(new IOMap(Long.parseLong("3"), "电动机M3退出点动按钮按下", "I0.4")));
        log.info("Preloading " + this.ioTableRepository.save(new IOMap(Long.parseLong("3"), "电动机M3进入点动按钮按下", "I0.5")));
        log.info("Preloading " + this.ioTableRepository.save(new IOMap(Long.parseLong("3"), "电动机M4（正转）上升点动按钮按下", "I0.6")));
        log.info("Preloading " + this.ioTableRepository.save(new IOMap(Long.parseLong("3"), "电动机M4（反转）下降点动按钮按下", "I0.7")));
        log.info("Preloading " + this.ioTableRepository.save(new IOMap(Long.parseLong("3"), "自动进给停止按钮按下", "I1.0")));
        log.info("Preloading " + this.ioTableRepository.save(new IOMap(Long.parseLong("3"), "总停止按钮按下", "I1.1")));
        log.info("Preloading " + this.ioTableRepository.save(new IOMap(Long.parseLong("3"), "电动机M2高速转换开关打开", "I1.2")));
        log.info("Preloading " + this.ioTableRepository.save(new IOMap(Long.parseLong("3"), "电动机M2低速转换开关打开", "I1.3")));
        log.info("Preloading " + this.ioTableRepository.save(new IOMap(Long.parseLong("3"), "自动进给启动按钮按下", "I1.4")));
        log.info("Preloading " + this.ioTableRepository.save(new IOMap(Long.parseLong("3"), "电磁吸盘充磁可调控制", "I1.5")));
        log.info("Preloading " + this.ioTableRepository.save(new IOMap(Long.parseLong("3"), "电磁吸盘充磁不可调控制", "I1.6")));
        log.info("Preloading " + this.ioTableRepository.save(new IOMap(Long.parseLong("3"), "冷却泵电动机控制", "I1.7")));
        log.info("Preloading " + this.ioTableRepository.save(new IOMap(Long.parseLong("3"), "砂轮升降电动机手动控制", "I2.0")));
        log.info("Preloading " + this.ioTableRepository.save(new IOMap(Long.parseLong("3"), "自动进给控制", "I2.1")));
        log.info("Preloading " + this.ioTableRepository.save(new IOMap(Long.parseLong("3"), "工作台退出限位行程开关打开", "I2.2")));
        log.info("Preloading " + this.ioTableRepository.save(new IOMap(Long.parseLong("3"), "工作台进入限位行程开关打开", "I2.3")));
        log.info("Preloading " + this.ioTableRepository.save(new IOMap(Long.parseLong("3"), "砂轮升降上限位行程开关打开", "I2.4")));
        log.info("Preloading " + this.ioTableRepository.save(new IOMap(Long.parseLong("3"), "电动指示灯亮", "Q0.0")));
        log.info("Preloading " + this.ioTableRepository.save(new IOMap(Long.parseLong("3"), "砂轮指示灯亮", "Q0.1")));
        log.info("Preloading " + this.ioTableRepository.save(new IOMap(Long.parseLong("3"), "电压继电器闭合", "Q0.2")));
        log.info("Preloading " + this.ioTableRepository.save(new IOMap(Long.parseLong("3"), "自动进给限位行程开关打开", "I2.5")));
        log.info("Preloading " + this.ioTableRepository.save(new IOMap(Long.parseLong("3"), "电磁吸盘欠电流控制", "I2.6")));
        log.info("Preloading " + this.ioTableRepository.save(new IOMap(Long.parseLong("3"), "砂轮电动机M1接触器KM1闭合", "Q0.3")));
        log.info("Preloading " + this.ioTableRepository.save(new IOMap(Long.parseLong("3"), "砂轮电动机M1接触器KM2闭合", "Q0.4")));
        log.info("Preloading " + this.ioTableRepository.save(new IOMap(Long.parseLong("3"), "砂轮电动机M1接触器KM3闭合", "Q0.5")));
        log.info("Preloading " + this.ioTableRepository.save(new IOMap(Long.parseLong("3"), "工作台转动电动机低速接触器闭合", "Q0.6")));
        log.info("Preloading " + this.ioTableRepository.save(new IOMap(Long.parseLong("3"), "工作台转动电动机高速接触器闭合", "Q0.7")));
        log.info("Preloading " + this.ioTableRepository.save(new IOMap(Long.parseLong("3"), "工作台移动电动机正转接触器闭合", "Q1.0")));
        log.info("Preloading " + this.ioTableRepository.save(new IOMap(Long.parseLong("3"), "工作台移动电动机反转接触器闭合", "Q1.1")));
        log.info("Preloading " + this.ioTableRepository.save(new IOMap(Long.parseLong("3"), "砂轮升降电动机上升接触器闭合", "Q1.2")));
        log.info("Preloading " + this.ioTableRepository.save(new IOMap(Long.parseLong("3"), "砂轮升降电动机下降接触器闭合", "Q1.3")));
        log.info("Preloading " + this.ioTableRepository.save(new IOMap(Long.parseLong("3"), "冷却泵电动机接触器闭合", "Q1.4")));
        log.info("Preloading " + this.ioTableRepository.save(new IOMap(Long.parseLong("3"), "自动进给电动机接触器闭合", "Q1.5")));
        log.info("Preloading " + this.ioTableRepository.save(new IOMap(Long.parseLong("3"), "电磁吸盘控制接触器闭合", "Q1.6")));
        log.info("Preloading " + this.ioTableRepository.save(new IOMap(Long.parseLong("3"), "自动进给控制电磁铁", "Q1.7")));
        log.info("Preloading " + this.ioTableRepository.save(new IOMap(Long.parseLong("3"), "中间继电器K1闭合", "Q2.0")));
        log.info("Preloading " + this.ioTableRepository.save(new IOMap(Long.parseLong("3"), "中间继电器K2闭合", "Q2.1")));
        log.info("Preloading " + this.ioTableRepository.save(new IOMap(Long.parseLong("3"), "中间继电器K3闭合", "Q2.2")));

    }
}