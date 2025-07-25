<script src="@/js/paipan/liuyao.js"></script>


<template>
  <div class="vue">

    <div class="region">
      <div class="header1">
        ༺༒༻ 六爻 ༺༒༻
      </div>
      <div class="header2">
        六爻，是中国传统占卜方法《周易》中的核心体系，通过六个爻位的阴阳变化组合成64种卦象，用以推测事物的发展趋势和吉凶祸福；
        <br />
        以“铜钱摇卦”为经典起卦方式，通过三次抛掷铜钱记录正反面，最终形成六个爻位（初爻至六爻）的阴阳组合，并结合天干地支、五行生克等原理进行解析 ...
      </div>
    </div>

    <div class="data">

      <div
        class="nodata"
        v-show="!isData"
      >

        <video
          ref="videoRef"
          autoplay
          loop
          :muted="true"
        >
          <source
            src="@/assets/img/paipan/loading.mp4"
            type="video/mp4"
          >
        </video>

        <div class="option">

          <div class="title">
            ༺༒༻ 六爻 ༺༒༻
            <span class="type">
              <Tag
                color="success"
              >
                卜
              </Tag>
            </span>
          </div>

          <div class="item">

            <div class="name">
              <input
                placeholder="请输入姓名"
                v-model="name"
                maxlength="10"
              />
            </div>

            <div class="occupy">
              <input
                placeholder="请输入占事"
                v-model="occupy"
                maxlength="10"
                @click="occupyPrompt"
              />
            </div>

            <div class="dateType">
              <el-radio-group
                v-model="dateType"
                v-for="item in dateTypeOptions"
                :key="item"
              >
                <el-radio-button
                  :label="item.label"
                  :value="item.value"
                />
              </el-radio-group>
            </div>

            <div class="sex">
              <el-radio-group
                v-model="sex"
                v-for="item in sexOptions"
                :key="item"
              >
                <el-radio-button
                  :label="item.label"
                  :value="item.value"
                />
              </el-radio-group>
            </div>

            <div class="date">
              <el-date-picker
                :clearable="false"
                v-model="date"
                type="datetime"
                format="YYYY-MM-DD HH:mm:ss"
                placeholder="请选择日期"
                :editable="false"
                style="width:60%;"
                @change="getDateGanZhiMethod"
              />
              <el-radio-group
                class="leapMonth"
                v-model="leapMonthType"
                v-for="item in leapMonthTypeOptions"
                :key="item"
              >
                <el-radio-button
                  :label="item.label"
                  :value="item.value"
                />
              </el-radio-group>
            </div>

            <el-collapse>
              <el-collapse-item title="高级选项" name="1">
                <div class="other">
                  <div class="title">
                    节气类型
                  </div>
                  <div class="kuang">
                    <Select
                      v-model="jieQiType"
                      class="select"
                    >
                      <Option
                        v-for="item in jieQiTypeOptions"
                        :key="item"
                        :label="item.label"
                        :value="item.value"
                      >
                        {{ item.label }}
                      </Option>
                    </Select>
                  </div>
                </div>

                <div class="other">
                  <div class="title">
                    排盘类型
                  </div>
                  <div class="kuang">
                    <Select
                      v-model="paiPanType"
                      class="select"
                    >
                      <Option
                        v-for="item in paiPanTypeOptions"
                        :key="item"
                        :label="item.label"
                        :value="item.value"
                      >
                        {{ item.label }}
                      </Option>
                    </Select>
                  </div>
                </div>

                <div class="other">
                  <div class="title">
                    年柱类型
                  </div>
                  <div class="kuang">
                    <Select
                      v-model="yearGanZhiType"
                      class="select"
                    >
                      <Option
                        v-for="item in yearGanZhiTypeOptions"
                        :key="item"
                        :label="item.label"
                        :value="item.value"
                      >
                        {{ item.label }}
                      </Option>
                    </Select>
                  </div>
                </div>

                <div class="other">
                  <div class="title">
                    月柱类型
                  </div>
                  <div class="kuang">
                    <Select
                      v-model="monthGanZhiType"
                      class="select"
                    >
                      <Option
                        v-for="item in monthGanZhiTypeOptions"
                        :key="item"
                        :label="item.label"
                        :value="item.value"
                      >
                        {{ item.label }}
                      </Option>
                    </Select>
                  </div>
                </div>

                <div class="other">
                  <div class="title">
                    日柱类型
                  </div>
                  <div class="kuang">
                    <Select
                      v-model="dayGanZhiType"
                      class="select"
                    >
                      <Option
                        v-for="item in dayGanZhiTypeOptions"
                        :key="item"
                        :label="item.label"
                        :value="item.value"
                      >
                        {{ item.label }}
                      </Option>
                    </Select>
                  </div>
                </div>
              </el-collapse-item>
            </el-collapse>

            <div class="paipan">
              <Button
                type="primary"
                class="button"
                @click="paiPanMethod"
              >
                开始排盘
              </Button>
            </div>

          </div>

        </div>

      </div>

      <div
        class="yesdata"
        v-if="isData"
      >

        <div class="option">
          <Button
            type="primary"
            class="button"
            @click="fanHuiPaiPanMethod"
          >
            返回排盘
          </Button>
          <div class="float-right">
            <Button
              type="success"
              class="button2"
              @click="jiChuMethod"
            >
              <b v-if="dataPage === 1">
                <Icon type="md-pin" />
                基础信息
              </b>
              <span v-else>基础信息</span>
            </Button>
          </div>
        </div>

        <div class="data">

          <div class="hrader">
            <div class="name">
              <Ellipsis
                :text="data.name"
                :length="3"
                tooltip
              />
            </div>
            <div class="date">
              <span class="other">（{{ data.sex + '、' + data.zao }}）</span>
              <span class="item">公历{{ data.solarStr }}</span>
              <span class="item">农历{{ data.lunarStr }}</span>
              <span class="item">{{ data.xingQi }}</span>
              <span class="item">{{ data.jiJie }}</span>
              <span
                class="item"
                v-if="data.wuBuYuShi"
              >
                <Tag color="error">五不遇时</Tag>
              </span>
            </div>
            <div class="shengxiao">
              {{ data.shengXiao }}
            </div>
          </div>

          <div class="border">

            <!-- 基础信息 -->
            <div
              class="jichu"
              v-if="dataPage === 1"
            >

              <div class="go bgi1">
                <div class="item">
                  <div class="title">排盘方式</div>
                  <div class="content">
                    <span v-if="paiPanType === 0">
                      日期
                    </span>
                    <span v-if="paiPanType === 1">
                      自动
                    </span>
                    <span v-if="paiPanType === 2">
                      手动
                    </span>
                  </div>
                </div>
                <div class="item">
                  <div class="title">年命信息</div>
                  <div class="content">
                    <span v-if="data.yearGanZhiNaYin">
                      {{ data.yearGanZhiNaYin.substring(0, 2) }}<span v-html="wuXingGaoLiangMethod(data.yearGanZhiNaYin.substring(2, 3))"></span>命
                    </span>
                  </div>
                </div>
                <div class="item">
                  <div class="title">生肖星座</div>
                  <div class="content">
                    {{ data.shengXiao + '、' + data.xingZuo }}
                  </div>
                </div>
                <div class="item">
                  <div class="title">日主属性</div>
                  <div class="content">
                    <span v-html="ganZhiGaoLiangMethod(data.yearGan)"></span><span v-html="wuXingGaoLiangMethod(data.yearGanWuXing)"></span>
                  </div>
                </div>
              </div>

              <div class="go bgi2">
                <div class="item">
                  <div class="title">生辰八字</div>
                  <div class="content">
                    <span v-html="ganZhiGaoLiangMethod(data.yearGan)"></span>
                    <span v-html="ganZhiGaoLiangMethod(data.yearZhi)"></span>&nbsp;
                    <span v-html="ganZhiGaoLiangMethod(data.monthGan)"></span>
                    <span v-html="ganZhiGaoLiangMethod(data.monthZhi)"></span>&nbsp;
                    <span v-html="ganZhiGaoLiangMethod(data.dayGan)"></span>
                    <span v-html="ganZhiGaoLiangMethod(data.dayZhi)"></span>&nbsp;
                    <span v-html="ganZhiGaoLiangMethod(data.hourGan)"></span>
                    <span v-html="ganZhiGaoLiangMethod(data.hourZhi)"></span>
                  </div>
                </div>
                <div class="item">
                  <div class="title">八字五行</div>
                  <div class="content">
                    <span v-html="wuXingGaoLiangMethod(data.yearGanWuXing)"></span>
                    <span v-html="wuXingGaoLiangMethod(data.yearZhiWuXing)"></span>&nbsp;
                    <span v-html="wuXingGaoLiangMethod(data.monthGanWuXing)"></span>
                    <span v-html="wuXingGaoLiangMethod(data.monthZhiWuXing)"></span>&nbsp;
                    <span v-html="wuXingGaoLiangMethod(data.dayGanWuXing)"></span>
                    <span v-html="wuXingGaoLiangMethod(data.dayZhiWuXing)"></span>&nbsp;
                    <span v-html="wuXingGaoLiangMethod(data.hourGanWuXing)"></span>
                    <span v-html="wuXingGaoLiangMethod(data.hourZhiWuXing)"></span>
                  </div>
                </div>
                <div class="item">
                  <div class="title">八字空亡</div>
                  <div class="content">
                    <span
                      v-if="data.yearGanZhiKongWang"
                      v-html="ganZhiGaoLiangMethod(data.yearGanZhiKongWang.substring(0, 1))"
                    ></span>
                    <span
                      v-if="data.yearGanZhiKongWang"
                      v-html="ganZhiGaoLiangMethod(data.yearGanZhiKongWang.substring(1, 2))"
                    ></span>&nbsp;
                    <span
                      v-if="data.monthGanZhiKongWang"
                      v-html="ganZhiGaoLiangMethod(data.monthGanZhiKongWang.substring(0, 1))"
                    ></span>
                    <span
                      v-if="data.monthGanZhiKongWang"
                      v-html="ganZhiGaoLiangMethod(data.monthGanZhiKongWang.substring(1, 2))"
                    ></span>&nbsp;
                    <span
                      v-if="data.dayGanZhiKongWang"
                      v-html="ganZhiGaoLiangMethod(data.dayGanZhiKongWang.substring(0, 1))"
                    ></span>
                    <span
                      v-if="data.dayGanZhiKongWang"
                      v-html="ganZhiGaoLiangMethod(data.dayGanZhiKongWang.substring(1, 2))"
                    ></span>&nbsp;
                    <span
                      v-if="data.hourGanZhiKongWang"
                      v-html="ganZhiGaoLiangMethod(data.hourGanZhiKongWang.substring(0, 1))"
                    ></span>
                    <span
                      v-if="data.hourGanZhiKongWang"
                      v-html="ganZhiGaoLiangMethod(data.hourGanZhiKongWang.substring(1, 2))"
                    ></span>
                  </div>
                </div>
                <div class="item">
                  <div class="title">八字纳音</div>
                  <div class="content size1">
                    <span v-if="data.yearGanZhiNaYin">
                      {{ data.yearGanZhiNaYin.substring(0, 2) }}<span v-html="wuXingGaoLiangMethod(data.yearGanZhiNaYin.substring(2, 3))"></span>
                    </span>&nbsp;
                    <span v-if="data.monthGanZhiNaYin">
                      {{ data.monthGanZhiNaYin.substring(0, 2) }}<span v-html="wuXingGaoLiangMethod(data.monthGanZhiNaYin.substring(2, 3))"></span>
                    </span>&nbsp;
                    <span v-if="data.dayGanZhiNaYin">
                      {{ data.dayGanZhiNaYin.substring(0, 2) }}<span v-html="wuXingGaoLiangMethod(data.dayGanZhiNaYin.substring(2, 3))"></span>
                    </span>&nbsp;
                    <span v-if="data.hourGanZhiNaYin">
                      {{ data.hourGanZhiNaYin.substring(0, 2) }}<span v-html="wuXingGaoLiangMethod(data.hourGanZhiNaYin.substring(2, 3))"></span>
                    </span>
                  </div>
                </div>
              </div>

              <div class="go bgi1">
                <div class="item">
                  <div class="title">驿马</div>
                  <div class="content">
                    {{ data.shenSha.yiMa }}
                  </div>
                </div>
                <div class="item">
                  <div class="title">天马</div>
                  <div class="content">
                    {{ data.shenSha.tianMa }}
                  </div>
                </div>
                <div class="item">
                  <div class="title">禄马</div>
                  <div class="content">
                    {{ data.shenSha.luMa }}
                  </div>
                </div>
                <div class="item">
                  <div class="title">天喜</div>
                  <div class="content">
                    {{ data.shenSha.tianXi }}
                  </div>
                </div>
                <div class="item">
                  <div class="title">天医</div>
                  <div class="content">
                    {{ data.shenSha.tianYi }}
                  </div>
                </div>
                <div class="item">
                  <div class="title">皇恩</div>
                  <div class="content">
                    {{ data.shenSha.huangEn }}
                  </div>
                </div>
                <div class="item">
                  <div class="title">灾煞</div>
                  <div class="content">
                    {{ data.shenSha.zaiSha }}
                  </div>
                </div>
                <div class="item">
                  <div class="title">劫煞</div>
                  <div class="content">
                    {{ data.shenSha.jieSha }}
                  </div>
                </div>
                <div class="item">
                  <div class="title">文昌</div>
                  <div class="content">
                    {{ data.shenSha.wenChangGuiRen }}
                  </div>
                </div>
                <div class="item">
                  <div class="title">华盖</div>
                  <div class="content">
                    {{ data.shenSha.huaGai }}
                  </div>
                </div>
                <div class="item">
                  <div class="title">谋星</div>
                  <div class="content">
                    {{ data.shenSha.mouXing }}
                  </div>
                </div>
                <div class="item">
                  <div class="title">将星</div>
                  <div class="content">
                    {{ data.shenSha.jiangXing }}
                  </div>
                </div>
              </div>

              <div class="go bgi2">
                <div class="item">
                  <div class="title">天乙</div>
                  <div class="content">
                    {{ data.shenSha.tianYiGuiRen }}
                  </div>
                </div>
                <div class="item">
                  <div class="title">天德</div>
                  <div class="content">
                    {{ data.shenSha.tianDeGuiRen }}
                  </div>
                </div>
                <div class="item">
                  <div class="title">月德</div>
                  <div class="content">
                    {{ data.shenSha.yueDeGuiRen }}
                  </div>
                </div>
                <div class="item">
                  <div class="title">太极</div>
                  <div class="content">
                    {{ data.shenSha.taiJiGuiRen }}
                  </div>
                </div>
                <div class="item">
                  <div class="title">福星</div>
                  <div class="content">
                    {{ data.shenSha.fuXingGuiRen }}
                  </div>
                </div>
                <div class="item">
                  <div class="title">咸池</div>
                  <div class="content">
                    {{ data.shenSha.xianChi }}
                  </div>
                </div>
                <div class="item">
                  <div class="title">符印</div>
                  <div class="content">
                    {{ data.shenSha.tangFuGuoYin }}
                  </div>
                </div>
                <div class="item">
                  <div class="title">阳刃</div>
                  <div class="content">
                    {{ data.shenSha.yangRen }}
                  </div>
                </div>
                <div class="item">
                  <div class="title">飞刃</div>
                  <div class="content">
                    {{ data.shenSha.feiRen }}
                  </div>
                </div>
                <div class="item">
                  <div class="title">天元禄</div>
                  <div class="content">
                    {{ data.shenSha.tianYuanLu }}
                  </div>
                </div>
                <div class="item">
                  <div class="title"></div>
                  <div class="content">

                  </div>
                </div>
                <div class="item">
                  <div class="title"></div>
                  <div class="content">

                  </div>
                </div>
              </div>

              <Row :gutter="10">
                <Col span="12">
                <div class="gua">
                  <div class="title">
                    <Tag
                      color="blue"
                      class="name"
                    >
                      本卦：{{ data.benGuaName }}
                    </Tag>
                    <Tag color="cyan">{{ data.benGuaType }}</Tag>
                    <Tag color="default">卦身：{{ data.benGuaGuaShen }}</Tag>
                  </div>
                  <div class="divider1">
                    <el-divider />
                  </div>
                  <div class="tip">
                    <span class="ym">爻名</span>
                    <span class="gx">卦象</span>
                    <span class="sy">世应</span>
                    <span class="lq">六亲</span>
                    <span class="gz">干支</span>
                    <span class="wx">五行</span>
                    <span class="ls">六神</span>
                    <span class="yc2">爻辞</span>
                  </div>
                  <div class="main">
                    <div
                      class="yaoming"
                      v-if="data.benGuaLiuYaoName"
                    >
                      <div
                        v-for="index in 6"
                        :key="index"
                      >
                        {{ data.benGuaLiuYaoName[liuYaoIndex[index - 1]] }}
                      </div>
                    </div>
                    <div
                      class="guaxiang"
                      v-if="data.benGuaAs"
                    >
                      <div>{{ data.benGuaAs }}</div>
                    </div>

                    <div
                      class="mark"
                      v-if="data.liuYaoAsMark"
                    >
                      <div
                        v-for="index in 6"
                        :key="index"
                      >
                        <span v-if="'' !== data.liuYaoAsMark[liuYaoIndex[index - 1]]">
                          {{ data.liuYaoAsMark[liuYaoIndex[index - 1]] }}
                        </span>
                        <span v-else>
                          <div class="kong"></div>
                        </span>
                      </div>
                    </div>

                    <div
                      class="shiying"
                      v-if="data.benGuaLiuYaoShiYing"
                    >
                      <div
                        v-for="index in 6"
                        :key="index"
                      >
                        {{ data.benGuaLiuYaoShiYing[liuYaoIndex[index - 1]] }}
                      </div>
                    </div>

                    <div
                      class="liuqin"
                      v-if="data.benGuaLiuYaoLiuQin"
                    >
                      <div
                        v-for="index in 6"
                        :key="index"
                      >
                        {{ data.benGuaLiuYaoLiuQin[liuYaoIndex[index - 1]] }}
                      </div>
                    </div>

                    <div
                      class="ganzhi"
                      v-if="data.benGuaLiuYaoGanZhi"
                    >
                      <div
                        v-for="index in 6"
                        :key="index"
                      >
                        <span v-html="ganZhiGaoLiangMethod(data.benGuaLiuYaoGanZhi[liuYaoIndex[index - 1]].substring(0, 1))"></span>
                        <span v-html="ganZhiGaoLiangMethod(data.benGuaLiuYaoGanZhi[liuYaoIndex[index - 1]].substring(1, 2))"></span>(<span class="nayin">{{ data.benGuaLiuYaoNaYin[liuYaoIndex[index - 1]] }} </span>)
                      </div>
                    </div>

                    <div
                      class="wuxing"
                      v-if="data.benGuaLiuYaoWuXing"
                    >
                      <div
                        v-for="index in 6"
                        :key="index"
                      >
                        <span v-html="wuXingGaoLiangMethod(data.benGuaLiuYaoWuXing[liuYaoIndex[index - 1]])"></span>
                      </div>
                    </div>

                    <div
                      class="liushen"
                      v-if="data.benGuaLiuYaoLiuShen"
                    >
                      <div
                        v-for="index in 6"
                        :key="index"
                      >
                        {{ data.benGuaLiuYaoLiuShen[liuYaoIndex[index - 1]] }}
                      </div>
                    </div>

                    <div
                      class="yaoci"
                      v-if="data.benGuaLiuYaoYaoCi"
                    >
                      <div
                        v-for="index in 6"
                        :key="index"
                      >
                        <b>{{ data.benGuaLiuYaoYaoCi[liuYaoIndex[index - 1]] }}</b>
                      </div>
                    </div>
                  </div>
                </div>
                </Col>
                <Col span="12">
                <div class="gua">
                  <div class="title">
                    <Tag
                      color="blue"
                      class="name"
                    >
                      <span class="fu">伏卦：{{ data.fuGuaName }}</span>
                    </Tag>
                    <Tag color="cyan">{{ data.fuGuaType }}</Tag>
                    <Tag color="default">卦身：{{ data.fuGuaGuaShen }}</Tag>
                  </div>
                  <div class="divider1">
                    <el-divider />
                  </div>
                  <div class="tip">
                    <span class="ym">爻名</span>
                    <span class="gx">卦象</span>
                    <span class="sy">世应</span>
                    <span class="fs">伏神</span>
                    <span class="lq">六亲</span>
                    <span class="gz">干支</span>
                    <span class="wx">五行</span>
                    <span class="ls">六神</span>
                    <span class="yc2">爻辞</span>
                  </div>
                  <div class="main">
                    <div
                      class="yaoming"
                      v-if="data.fuGuaLiuYaoName"
                    >
                      <div
                        v-for="index in 6"
                        :key="index"
                      >
                        {{ data.fuGuaLiuYaoName[liuYaoIndex[index - 1]] }}
                      </div>
                    </div>
                    <div
                      class="guaxiang"
                      v-if="data.fuGuaAs"
                    >
                      <div>{{ data.fuGuaAs }}</div>
                    </div>

                    <div
                      class="mark"
                      v-if="data.liuYaoAsMark"
                    >
                      <div
                        v-for="index in 6"
                        :key="index"
                      >
                        <div class="kong"></div>
                      </div>
                    </div>

                    <div
                      class="shiying"
                      v-if="data.fuGuaLiuYaoShiYing"
                    >
                      <div
                        v-for="index in 6"
                        :key="index"
                      >
                        {{ data.fuGuaLiuYaoShiYing[liuYaoIndex[index - 1]] }}
                      </div>
                    </div>

                    <div
                      class="fushen"
                      v-if="data.fuGuaLiuYaoFuShen"
                    >
                      <div
                        v-for="index in liuYaoIndex.length"
                        :key="index"
                      >
                        <div v-if="'' !== data.fuGuaLiuYaoFuShen [liuYaoIndex[index - 1]]">
                          <Icon type="ios-flash" />
                          <Icon type="ios-flash" />
                        </div>
                      </div>
                    </div>

                    <div
                      class="liuqi2"
                      v-if="data.fuGuaLiuYaoLiuQin"
                    >
                      <div
                        v-for="index in 6"
                        :key="index"
                      >
                        {{ data.fuGuaLiuYaoLiuQin[liuYaoIndex[index - 1]] }}
                      </div>
                    </div>

                    <div
                      class="ganzhi"
                      v-if="data.fuGuaLiuYaoGanZhi"
                    >
                      <div
                        v-for="index in 6"
                        :key="index"
                      >
                        <span v-html="ganZhiGaoLiangMethod(data.fuGuaLiuYaoGanZhi[liuYaoIndex[index - 1]].substring(0, 1))"></span>
                        <span v-html="ganZhiGaoLiangMethod(data.fuGuaLiuYaoGanZhi[liuYaoIndex[index - 1]].substring(1, 2))"></span>(<span class="nayin">{{ data.benGuaLiuYaoNaYin[liuYaoIndex[index - 1]] }} </span>)
                      </div>
                    </div>

                    <div
                      class="wuxing"
                      v-if="data.fuGuaLiuYaoWuXing"
                    >
                      <div
                        v-for="index in 6"
                        :key="index"
                      >
                        <span v-html="wuXingGaoLiangMethod(data.fuGuaLiuYaoWuXing[liuYaoIndex[index - 1]])"></span>
                      </div>
                    </div>

                    <div
                      class="liushen"
                      v-if="data.fuGuaLiuYaoLiuShen"
                    >
                      <div
                        v-for="index in 6"
                        :key="index"
                      >
                        {{ data.fuGuaLiuYaoLiuShen[liuYaoIndex[index - 1]] }}
                      </div>
                    </div>

                    <div
                      class="yaoci"
                      v-if="data.fuGuaLiuYaoYaoCi"
                    >
                      <div
                        v-for="index in 6"
                        :key="index"
                      >
                        <b>{{ data.fuGuaLiuYaoYaoCi[liuYaoIndex[index - 1]] }}</b>
                      </div>
                    </div>
                  </div>
                </div>
                </Col>
              </Row>

              <Row :gutter="10">
                <Col span="12">
                <div class="gua">
                  <div class="title">
                    <Tag
                      color="blue"
                      class="name"
                    >
                      变卦：{{ data.bianGuaName }}
                    </Tag>
                    <Tag color="cyan">{{ data.bianGuaType }}</Tag>
                    <Tag color="default">卦身：{{ data.bianGuaGuaShen }}</Tag>
                  </div>
                  <div class="divider1">
                    <el-divider />
                  </div>
                  <div class="tip">
                    <span class="ym">爻名</span>
                    <span class="gx">卦象</span>
                    <span class="sy">世应</span>
                    <span class="lq">六亲</span>
                    <span class="gz">干支</span>
                    <span class="wx">五行</span>
                    <span class="ls">六神</span>
                    <span class="yc2">爻辞</span>
                  </div>
                  <div class="main">
                    <div
                      class="yaoming"
                      v-if="data.bianGuaLiuYaoName"
                    >
                      <div
                        v-for="index in 6"
                        :key="index"
                      >
                        {{ data.bianGuaLiuYaoName[liuYaoIndex[index - 1]] }}
                      </div>
                    </div>
                    <div
                      class="guaxiang"
                      v-if="data.bianGuaAs"
                    >
                      <div>{{ data.bianGuaAs }}</div>
                    </div>

                    <div
                      class="mark"
                      v-if="data.liuYaoAsMark"
                    >
                      <div
                        v-for="index in 6"
                        :key="index"
                      >
                        <div class="kong"></div>
                      </div>
                    </div>

                    <div
                      class="shiying"
                      v-if="data.bianGuaLiuYaoShiYing"
                    >
                      <div
                        v-for="index in 6"
                        :key="index"
                      >
                        {{ data.bianGuaLiuYaoShiYing[liuYaoIndex[index - 1]] }}
                      </div>
                    </div>

                    <div
                      class="liuqin"
                      v-if="data.bianGuaLiuYaoLiuQin"
                    >
                      <div
                        v-for="index in 6"
                        :key="index"
                      >
                        {{ data.bianGuaLiuYaoLiuQin[liuYaoIndex[index - 1]] }}
                      </div>
                    </div>

                    <div
                      class="ganzhi"
                      v-if="data.bianGuaLiuYaoGanZhi"
                    >
                      <div
                        v-for="index in 6"
                        :key="index"
                      >
                        <span v-html="ganZhiGaoLiangMethod(data.bianGuaLiuYaoGanZhi[liuYaoIndex[index - 1]].substring(0, 1))"></span>
                        <span v-html="ganZhiGaoLiangMethod(data.bianGuaLiuYaoGanZhi[liuYaoIndex[index - 1]].substring(1, 2))"></span>(<span class="nayin">{{ data.benGuaLiuYaoNaYin[liuYaoIndex[index - 1]] }} </span>)
                      </div>
                    </div>

                    <div
                      class="wuxing"
                      v-if="data.bianGuaLiuYaoWuXing"
                    >
                      <div
                        v-for="index in 6"
                        :key="index"
                      >
                        <span v-html="wuXingGaoLiangMethod(data.bianGuaLiuYaoWuXing[liuYaoIndex[index - 1]])"></span>
                      </div>
                    </div>

                    <div
                      class="liushen"
                      v-if="data.bianGuaLiuYaoLiuShen"
                    >
                      <div
                        v-for="index in 6"
                        :key="index"
                      >
                        {{ data.bianGuaLiuYaoLiuShen[liuYaoIndex[index - 1]] }}
                      </div>
                    </div>

                    <div
                      class="yaoci"
                      v-if="data.bianGuaLiuYaoYaoCi"
                    >
                      <div
                        v-for="index in 6"
                        :key="index"
                      >
                        <b>{{ data.bianGuaLiuYaoYaoCi[liuYaoIndex[index - 1]] }}</b>
                      </div>
                    </div>
                  </div>
                </div>
                </Col>
                <Col span="12">
                <div class="gua">
                  <div class="title">
                    <Tag
                      color="blue"
                      class="name"
                    >
                      互卦：{{ data.huGuaName }}
                    </Tag>
                    <Tag color="cyan">{{ data.huGuaType }}</Tag>
                    <Tag color="default">卦身：{{ data.huGuaGuaShen }}</Tag>
                  </div>
                  <div class="divider1">
                    <el-divider />
                  </div>
                  <div class="tip">
                    <span class="ym">爻名</span>
                    <span class="gx">卦象</span>
                    <span class="sy">世应</span>
                    <span class="lq">六亲</span>
                    <span class="gz">干支</span>
                    <span class="wx">五行</span>
                    <span class="ls">六神</span>
                    <span class="yc2">爻辞</span>
                  </div>
                  <div class="main">
                    <div
                      class="yaoming"
                      v-if="data.huGuaLiuYaoName"
                    >
                      <div
                        v-for="index in 6"
                        :key="index"
                      >
                        {{ data.huGuaLiuYaoName[liuYaoIndex[index - 1]] }}
                      </div>
                    </div>
                    <div
                      class="guaxiang"
                      v-if="data.huGuaAs"
                    >
                      <div>{{ data.huGuaAs }}</div>
                    </div>

                    <div
                      class="mark"
                      v-if="data.liuYaoAsMark"
                    >
                      <div
                        v-for="index in 6"
                        :key="index"
                      >
                        <div class="kong"></div>
                      </div>
                    </div>

                    <div
                      class="shiying"
                      v-if="data.huGuaLiuYaoShiYing"
                    >
                      <div
                        v-for="index in 6"
                        :key="index"
                      >
                        {{ data.huGuaLiuYaoShiYing[liuYaoIndex[index - 1]] }}
                      </div>
                    </div>

                    <div
                      class="liuqin"
                      v-if="data.huGuaLiuYaoLiuQin"
                    >
                      <div
                        v-for="index in 6"
                        :key="index"
                      >
                        {{ data.huGuaLiuYaoLiuQin[liuYaoIndex[index - 1]] }}
                      </div>
                    </div>

                    <div
                      class="ganzhi"
                      v-if="data.huGuaLiuYaoGanZhi"
                    >
                      <div
                        v-for="index in 6"
                        :key="index"
                      >
                        <span v-html="ganZhiGaoLiangMethod(data.huGuaLiuYaoGanZhi[liuYaoIndex[index - 1]].substring(0, 1))"></span>
                        <span v-html="ganZhiGaoLiangMethod(data.huGuaLiuYaoGanZhi[liuYaoIndex[index - 1]].substring(1, 2))"></span>(<span class="nayin">{{ data.benGuaLiuYaoNaYin[liuYaoIndex[index - 1]] }} </span>)
                      </div>
                    </div>

                    <div
                      class="wuxing"
                      v-if="data.huGuaLiuYaoWuXing"
                    >
                      <div
                        v-for="index in 6"
                        :key="index"
                      >
                        <span v-html="wuXingGaoLiangMethod(data.huGuaLiuYaoWuXing[liuYaoIndex[index - 1]])"></span>
                      </div>
                    </div>

                    <div
                      class="liushen"
                      v-if="data.huGuaLiuYaoLiuShen"
                    >
                      <div
                        v-for="index in 6"
                        :key="index"
                      >
                        {{ data.huGuaLiuYaoLiuShen[liuYaoIndex[index - 1]] }}
                      </div>
                    </div>

                    <div
                      class="yaoci"
                      v-if="data.huGuaLiuYaoYaoCi"
                    >
                      <div
                        v-for="index in 6"
                        :key="index"
                      >
                        <b>{{ data.huGuaLiuYaoYaoCi[liuYaoIndex[index - 1]] }}</b>
                      </div>
                    </div>
                  </div>
                </div>
                </Col>
              </Row>

              <Row :gutter="10">
                <Col span="12">
                <div class="gua">
                  <div class="title">
                    <Tag
                      color="blue"
                      class="name"
                    >
                      错卦：{{ data.cuoGuaName }}
                    </Tag>
                    <Tag color="cyan">{{ data.cuoGuaType }}</Tag>
                    <Tag color="default">卦身：{{ data.cuoGuaGuaShen }}</Tag>
                  </div>
                  <div class="divider1">
                    <el-divider />
                  </div>
                  <div class="tip">
                    <span class="ym">爻名</span>
                    <span class="gx">卦象</span>
                    <span class="sy">世应</span>
                    <span class="lq">六亲</span>
                    <span class="gz">干支</span>
                    <span class="wx">五行</span>
                    <span class="ls">六神</span>
                    <span class="yc2">爻辞</span>
                  </div>
                  <div class="main">
                    <div
                      class="yaoming"
                      v-if="data.cuoGuaLiuYaoName"
                    >
                      <div
                        v-for="index in 6"
                        :key="index"
                      >
                        {{ data.cuoGuaLiuYaoName[liuYaoIndex[index - 1]] }}
                      </div>
                    </div>
                    <div
                      class="guaxiang"
                      v-if="data.cuoGuaAs"
                    >
                      <div>{{ data.cuoGuaAs }}</div>
                    </div>

                    <div
                      class="mark"
                      v-if="data.liuYaoAsMark"
                    >
                      <div
                        v-for="index in 6"
                        :key="index"
                      >
                        <div class="kong"></div>
                      </div>
                    </div>

                    <div
                      class="shiying"
                      v-if="data.cuoGuaLiuYaoShiYing"
                    >
                      <div
                        v-for="index in 6"
                        :key="index"
                      >
                        {{ data.cuoGuaLiuYaoShiYing[liuYaoIndex[index - 1]] }}
                      </div>
                    </div>

                    <div
                      class="liuqin"
                      v-if="data.cuoGuaLiuYaoLiuQin"
                    >
                      <div
                        v-for="index in 6"
                        :key="index"
                      >
                        {{ data.cuoGuaLiuYaoLiuQin[liuYaoIndex[index - 1]] }}
                      </div>
                    </div>

                    <div
                      class="ganzhi"
                      v-if="data.cuoGuaLiuYaoGanZhi"
                    >
                      <div
                        v-for="index in 6"
                        :key="index"
                      >
                        <span v-html="ganZhiGaoLiangMethod(data.cuoGuaLiuYaoGanZhi[liuYaoIndex[index - 1]].substring(0, 1))"></span>
                        <span v-html="ganZhiGaoLiangMethod(data.cuoGuaLiuYaoGanZhi[liuYaoIndex[index - 1]].substring(1, 2))"></span>(<span class="nayin">{{ data.benGuaLiuYaoNaYin[liuYaoIndex[index - 1]] }} </span>)
                      </div>
                    </div>

                    <div
                      class="wuxing"
                      v-if="data.cuoGuaLiuYaoWuXing"
                    >
                      <div
                        v-for="index in 6"
                        :key="index"
                      >
                        <span v-html="wuXingGaoLiangMethod(data.cuoGuaLiuYaoWuXing[liuYaoIndex[index - 1]])"></span>
                      </div>
                    </div>

                    <div
                      class="liushen"
                      v-if="data.cuoGuaLiuYaoLiuShen"
                    >
                      <div
                        v-for="index in 6"
                        :key="index"
                      >
                        {{ data.cuoGuaLiuYaoLiuShen[liuYaoIndex[index - 1]] }}
                      </div>
                    </div>

                    <div
                      class="yaoci"
                      v-if="data.cuoGuaLiuYaoYaoCi"
                    >
                      <div
                        v-for="index in 6"
                        :key="index"
                      >
                        <b>{{ data.cuoGuaLiuYaoYaoCi[liuYaoIndex[index - 1]] }}</b>
                      </div>
                    </div>
                  </div>
                </div>
                </Col>
                <Col span="12">
                <div class="gua">
                  <div class="title">
                    <Tag
                      color="blue"
                      class="name"
                    >
                      综卦：{{ data.zongGuaName }}
                    </Tag>
                    <Tag color="cyan">{{ data.zongGuaType }}</Tag>
                    <Tag color="default">卦身：{{ data.zongGuaGuaShen }}</Tag>
                  </div>
                  <div class="divider1">
                    <el-divider />
                  </div>
                  <div class="tip">
                    <span class="ym">爻名</span>
                    <span class="gx">卦象</span>
                    <span class="sy">世应</span>
                    <span class="lq">六亲</span>
                    <span class="gz">干支</span>
                    <span class="wx">五行</span>
                    <span class="ls">六神</span>
                    <span class="yc2">爻辞</span>
                  </div>
                  <div class="main">
                    <div
                      class="yaoming"
                      v-if="data.zongGuaLiuYaoName"
                    >
                      <div
                        v-for="index in 6"
                        :key="index"
                      >
                        {{ data.zongGuaLiuYaoName[liuYaoIndex[index - 1]] }}
                      </div>
                    </div>
                    <div
                      class="guaxiang"
                      v-if="data.zongGuaAs"
                    >
                      <div>{{ data.zongGuaAs }}</div>
                    </div>

                    <div
                      class="mark"
                      v-if="data.liuYaoAsMark"
                    >
                      <div
                        v-for="index in 6"
                        :key="index"
                      >
                        <div class="kong"></div>
                      </div>
                    </div>

                    <div
                      class="shiying"
                      v-if="data.zongGuaLiuYaoShiYing"
                    >
                      <div
                        v-for="index in 6"
                        :key="index"
                      >
                        {{ data.zongGuaLiuYaoShiYing[liuYaoIndex[index - 1]] }}
                      </div>
                    </div>

                    <div
                      class="liuqin"
                      v-if="data.zongGuaLiuYaoLiuQin"
                    >
                      <div
                        v-for="index in 6"
                        :key="index"
                      >
                        {{ data.zongGuaLiuYaoLiuQin[liuYaoIndex[index - 1]] }}
                      </div>
                    </div>

                    <div
                      class="ganzhi"
                      v-if="data.zongGuaLiuYaoGanZhi"
                    >
                      <div
                        v-for="index in 6"
                        :key="index"
                      >
                        <span v-html="ganZhiGaoLiangMethod(data.zongGuaLiuYaoGanZhi[liuYaoIndex[index - 1]].substring(0, 1))"></span>
                        <span v-html="ganZhiGaoLiangMethod(data.zongGuaLiuYaoGanZhi[liuYaoIndex[index - 1]].substring(1, 2))"></span>(<span class="nayin">{{ data.benGuaLiuYaoNaYin[liuYaoIndex[index - 1]] }} </span>)
                      </div>
                    </div>

                    <div
                      class="wuxing"
                      v-if="data.zongGuaLiuYaoWuXing"
                    >
                      <div
                        v-for="index in 6"
                        :key="index"
                      >
                        <span v-html="wuXingGaoLiangMethod(data.zongGuaLiuYaoWuXing[liuYaoIndex[index - 1]])"></span>
                      </div>
                    </div>

                    <div
                      class="liushen"
                      v-if="data.zongGuaLiuYaoLiuShen"
                    >
                      <div
                        v-for="index in 6"
                        :key="index"
                      >
                        {{ data.zongGuaLiuYaoLiuShen[liuYaoIndex[index - 1]] }}
                      </div>
                    </div>

                    <div
                      class="yaoci"
                      v-if="data.zongGuaLiuYaoYaoCi"
                    >
                      <div
                        v-for="index in 6"
                        :key="index"
                      >
                        <b>{{ data.zongGuaLiuYaoYaoCi[liuYaoIndex[index - 1]] }}</b>
                      </div>
                    </div>
                  </div>
                </div>
                </Col>
              </Row>

            </div>

          </div>

        </div>
      </div>

    </div>

  </div>
</template>


<style scoped lang="scss" src="@/css/paipan/liuyao.scss"></style>
