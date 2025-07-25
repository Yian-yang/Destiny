<script src="@/js/paipan/bazi.js"></script>


<template>
  <div class="vue">

    <div class="region">
      <div class="header1">
        ༺༒༻ 八字 ༺༒༻
      </div>
      <div class="header2">
        八字的历史起源悠久，可追溯到商周时期的干支纪年法；先秦时期，《易经》等经典为八字命理奠定了哲学基础，阴阳五行思想开始萌芽；
        <br />
        汉代，随着儒家天命观的发展，以干支为基础的算命术逐渐兴起。唐代，李虚中确立了以出生时间干支推断命运的方法，使八字命理得到认可 ...
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
          v-show="false"
        >
          <source
            src="@/assets/img/paipan/loading.mp4"
            type="video/mp4"
          >
        </video>

        <div class="option">

          <div class="title">
            ༺༒༻ 八字 ༺༒༻
            <span class="type">
              <Tag
                color="success"
              >
                命
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

            <div class="occupy" style="display: none;">
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
                placeholder="请选择日期和时间"
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

            <div class="other">
              <div class="title">
                大运轮数
              </div>
              <div class="kuang">
                <InputNumber
                  v-model="daYunLunShu"
                  :min="10"
                  :max="16"
                  controls-outside
                  :editable="false"
                />
              </div>
            </div>

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
                起运流派
              </div>
              <div class="kuang">
                <Select
                  v-model="qiYunLiuPaiType"
                  class="select"
                >
                  <Option
                    v-for="item in qiYunLiuPaiTypeOptions"
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
                人元司令
              </div>
              <div class="kuang">
                <Select
                  v-model="renYuanType"
                  class="select"
                >
                  <Option
                    v-for="item in renYuanTypeOptions"
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
            <el-switch
              v-model="ganZhiYinYang"
              inline-prompt
              style="--el-switch-on-color:#2d8cf0;"
              active-text="阴干支斜体"
              inactive-text="阴干支斜体"
              width="100"
            />
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
            <Button
              type="success"
              class="button2"
              @click="mingPanMethod"
            >
              <b v-if="dataPage === 2">
                <Icon type="md-pin" />
                命盘信息
              </b>
              <span v-else>命盘信息</span>
            </Button>
            <Button
              type="success"
              class="button2"
              @click="gengDuoMethod"
            >
              <b v-if="dataPage === 3">
                <Icon type="md-pin" />
                更多信息
              </b>
              <span v-else>更多信息</span>
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
                  <div class="title">年命信息</div>
                  <div class="content">
                    <span v-if="data.yearGanZhiNaYin">
                      {{ data.yearGanZhiNaYin.substring(0, 2) }}<span v-html="wuXingGaoLiangMethod(data.yearGanZhiNaYin.substring(2, 3))"></span>命
                    </span>
                  </div>
                </div>
                <div class="item">
                  <div class="title">命卦信息</div>
                  <div class="content">
                    {{ data.mingGua }}
                  </div>
                </div>
                <div class="item">
                  <div class="title">生肖星座</div>
                  <div class="content">
                    {{ data.shengXiao + '、' + data.xingZuo }}
                  </div>
                </div>
                <div class="item">
                  <div class="title">星宿信息</div>
                  <div class="content">
                    {{ data.xingXiu + '（' + data.xiuJiXiong + '）' }}
                  </div>
                </div>
              </div>

              <div class="go bgi2">
                <div class="item">
                  <div class="title">身体强弱</div>
                  <div class="content">
                    {{ data.shenTiQiangRuo }}
                  </div>
                </div>
                <div class="item">
                  <div class="title">人元司令</div>
                  <div class="content">
                    <span v-if="data.renYuanSiLingFenYe">
                      <span v-html="ganZhiGaoLiangMethod(data.renYuanSiLingFenYe.substring(0, 1))"></span><span v-html="wuXingGaoLiangMethod(data.renYuanSiLingFenYe.substring(1, 2))"></span>值令
                    </span>
                  </div>
                </div>
                <div class="item">
                  <div class="title">胎元胎息</div>
                  <div class="content">
                    <span v-if="data.taiYuanGanZhi">
                      <span v-html="ganZhiGaoLiangMethod2(data.taiYuanGanZhi)"></span>（{{ data.taiYuanGanZhiNaYin.substring(0, 2) }}<span v-html="wuXingGaoLiangMethod(data.taiYuanGanZhiNaYin.substring(2, 3))"></span>）
                    </span>&nbsp;
                    <span v-if="data.taiXiGanZhi">
                      <span v-html="ganZhiGaoLiangMethod2(data.taiXiGanZhi)"></span>（{{ data.taiXiGanZhiNaYin.substring(0, 2) }}<span v-html="wuXingGaoLiangMethod(data.taiXiGanZhiNaYin.substring(2, 3))"></span>）
                    </span>
                  </div>
                </div>
                <div class="item">
                  <div class="title">命宫身宫</div>
                  <div class="content">
                    <span v-if="data.mingGongGanZhi">
                      <span v-html="ganZhiGaoLiangMethod2(data.mingGongGanZhi)"></span>（{{ data.mingGongGanZhiNaYin.substring(0, 2) }}<span v-html="wuXingGaoLiangMethod(data.mingGongGanZhiNaYin.substring(2, 3))"></span>）
                    </span>&nbsp;
                    <span v-if="data.shenGongGanZhi">
                      <span v-html="ganZhiGaoLiangMethod2(data.shenGongGanZhi)"></span>（{{ data.shenGongGanZhiNaYin.substring(0, 2) }}<span v-html="wuXingGaoLiangMethod(data.shenGongGanZhiNaYin.substring(2, 3))"></span>）
                    </span>
                  </div>
                </div>
              </div>

              <div class="go bgi1">
                <div class="item">
                  <div class="title">生辰八字</div>
                  <div class="content">
                    <span v-html="ganZhiGaoLiangMethod2(data.yearGanZhi)"></span>&nbsp;
                    <span v-html="ganZhiGaoLiangMethod2(data.monthGanZhi)"></span>&nbsp;
                    <span v-html="ganZhiGaoLiangMethod2(data.dayGanZhi)"></span>&nbsp;
                    <span v-html="ganZhiGaoLiangMethod2(data.hourGanZhi)"></span>
                  </div>
                </div>
                <div class="item">
                  <div class="title">八字五行</div>
                  <div class="content">
                    <span v-html="wuXingGaoLiangMethod(data.yearGanZhiWuXing)"></span>&nbsp;
                    <span v-html="wuXingGaoLiangMethod(data.monthGanZhiWuXing)"></span>&nbsp;
                    <span v-html="wuXingGaoLiangMethod(data.dayGanZhiWuXing)"></span>&nbsp;
                    <span v-html="wuXingGaoLiangMethod(data.hourGanZhiWuXing)"></span>
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
                  <div class="content">
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

              <div class="go bgi2">
                <div class="item">
                  <div class="title">五行缺失</div>
                  <div class="content">
                    <span
                      v-if="data.wuXingQueShi.length === 0"
                      class="null"
                    >
                      无
                    </span>
                    <span v-else>
                      <span
                        v-for="index in data.wuXingQueShi.length"
                        :key="index"
                      >
                        <span v-html="wuXingGaoLiangMethod(data.wuXingQueShi[index - 1])"></span>
                        <span v-if="index !== data.wuXingQueShi.length">、</span>
                      </span>
                    </span>
                  </div>
                </div>
                <div class="item">
                  <div class="title mr-43">月相</div>
                  <div class="content">
                    {{ data.yueXiang }}
                  </div>
                </div>
                <div class="item">
                  <div class="title mr-43">月将</div>
                  <div class="content">
                    <span v-html="ganZhiGaoLiangMethod(data.yueJiang)"></span>
                  </div>
                </div>
                <div class="item">
                  <div class="title mr-29">月将神</div>
                  <div class="content">
                    {{ data.yueJiangShen }}
                  </div>
                </div>
              </div>

              <div class="go bgi1">
                <div class="item">
                  <div class="title mr-29">喜用神</div>
                  <div class="content">
                    <span
                      v-if="data.xiYongShen.length === 0"
                      class="null"
                    >
                      无
                    </span>
                    <span v-else>
                      <span
                        v-for="index in data.xiYongShen.length"
                        :key="index"
                      >
                        <span v-html="wuXingGaoLiangMethod(data.xiYongShen[index - 1])"></span>
                        <span v-if="index !== data.xiYongShen.length">、</span>
                      </span>
                    </span>
                  </div>
                </div>
                <div class="item">
                  <div class="title">喜用神位</div>
                  <div class="content">
                    <span
                      v-if="data.xiYongShenFangWei.length === 0"
                      class="null"
                    >
                      无
                    </span>
                    <span v-else>
                      <Ellipsis
                        :text="data.xiYongShenFangWei.join('、')"
                        :length="10"
                        tooltip
                      />
                    </span>
                  </div>
                </div>
                <div class="item">
                  <div class="title">日主属性</div>
                  <div class="content">
                    <span v-html="ganZhiGaoLiangMethod(data.yearGan)"></span><span v-html="wuXingGaoLiangMethod(data.yearGanWuXing)"></span>
                  </div>
                </div>
                <div class="item">
                  <div class="title mr-43"></div>
                  <div class="content">

                  </div>
                </div>
              </div>

              <div class="go bgi2">
                <div class="item">
                  <div class="title">节气日期</div>
                  <div class="content">
                    {{ data.prevJie + ' ' + data.prevJieDateStr }}、{{ data.nextJie + ' ' + data.nextJieDateStr }}
                  </div>
                </div>
                <div class="item">
                  <div class="title">出生信息</div>
                  <div class="content">
                    出生于{{ data.chuShengJieQi }}
                  </div>
                </div>
              </div>

              <div class="caihua">
                <el-tabs
                  v-model="caiHuaTab"
                  type="card"
                  stretch="true"
                >
                  <el-tab-pane
                    label="正财年"
                    name="1"
                  >
                    <div
                      v-if="data.zhengCaiYun && data.zhengCaiYun.length"
                      class="tab"
                    >
                      <span
                        v-for="index in data.zhengCaiYun.length"
                        :key="index"
                      >
                        <div class="jianju">
                          <span v-html="ganZhiGaoLiangMethod(data.zhengCaiYun[index - 1][2].substring(0, 1))"></span><span v-html="ganZhiGaoLiangMethod(data.zhengCaiYun[index - 1][2].substring(1, 2))"></span>年
                          ({{ data.zhengCaiYun[index - 1][0] }}年 / {{ data.zhengCaiYun[index - 1][1] }}岁)
                          <span v-if="'' !== data.zhengCaiYun[index - 1][3]">
                            <el-tooltip
                              placement="top"
                              :enterable="false"
                            >
                              <template #content>
                                {{ data.zhengCaiYun[index - 1][3] }}，正财运可能不会过于理想
                              </template>
                              <Tag
                                class="tag"
                                color="warning"
                              >
                                合化
                              </Tag>
                            </el-tooltip>
                          </span>
                        </div>
                      </span>
                    </div>
                  </el-tab-pane>
                  <el-tab-pane
                    label="偏财年"
                    name="2"
                  >
                    <div
                      v-if="data.pianCaiYun && data.pianCaiYun.length"
                      class="tab"
                    >
                      <span
                        v-for="index in data.pianCaiYun.length"
                        :key="index"
                      >
                        <div class="jianju">
                          <span v-html="ganZhiGaoLiangMethod(data.pianCaiYun[index - 1][2].substring(0, 1))"></span><span v-html="ganZhiGaoLiangMethod(data.pianCaiYun[index - 1][2].substring(1, 2))"></span>年
                          ({{ data.pianCaiYun[index - 1][0] }}年 / {{ data.pianCaiYun[index - 1][1] }}岁)
                          <span v-if="'' !== data.pianCaiYun[index - 1][3]">
                            <el-tooltip
                              placement="top"
                              :enterable="false"
                            >
                              <template #content>
                                {{ data.pianCaiYun[index - 1][3] }}，偏财运可能不会过于理想
                              </template>
                              <Tag
                                class="tag"
                                color="warning"
                              >
                                合化
                              </Tag>
                            </el-tooltip>
                          </span>
                        </div>
                      </span>
                    </div>
                  </el-tab-pane>
                  <el-tab-pane
                    label="正桃花年"
                    name="3"
                  >
                    <div
                      v-if="data.zhengTaoHua && data.zhengTaoHua.length"
                      class="tab"
                    >
                      <span
                        v-for="index in data.zhengTaoHua.length"
                        :key="index"
                      >
                        <div class="jianju">
                          <span v-html="ganZhiGaoLiangMethod(data.zhengTaoHua[index - 1][2].substring(0, 1))"></span><span v-html="ganZhiGaoLiangMethod(data.zhengTaoHua[index - 1][2].substring(1, 2))"></span>年
                          ({{ data.zhengTaoHua[index - 1][0] }}年 / {{ data.zhengTaoHua[index - 1][1] }}岁)
                          <span v-if="'' !== data.zhengTaoHua[index - 1][3]">
                            <el-tooltip
                              placement="top"
                              :enterable="false"
                            >
                              <template #content>
                                {{ data.zhengTaoHua[index - 1][3] }}，正桃花运可能不会过于理想
                              </template>
                              <Tag
                                class="tag"
                                color="warning"
                              >
                                合化
                              </Tag>
                            </el-tooltip>
                          </span>
                        </div>
                      </span>
                    </div>
                  </el-tab-pane>
                  <el-tab-pane
                    label="偏桃花年"
                    name="4"
                  >
                    <div
                      v-if="data.pianTaoHua && data.pianTaoHua.length"
                      class="tab"
                    >
                      <span
                        v-for="index in data.pianTaoHua.length"
                        :key="index"
                      >
                        <div class="jianju">
                          <span v-html="ganZhiGaoLiangMethod(data.pianTaoHua[index - 1][2].substring(0, 1))"></span><span v-html="ganZhiGaoLiangMethod(data.pianTaoHua[index - 1][2].substring(1, 2))"></span>年
                          ({{ data.pianTaoHua[index - 1][0] }}年 / {{ data.pianTaoHua[index - 1][1] }}岁)
                          <span v-if="'' !== data.pianTaoHua[index - 1][3]">
                            <el-tooltip
                              placement="top"
                              :enterable="false"
                            >
                              <template #content>
                                {{ data.pianTaoHua[index - 1][3] }}，偏桃花运可能不会过于理想
                              </template>
                              <Tag
                                class="tag"
                                color="warning"
                              >
                                合化
                              </Tag>
                            </el-tooltip>
                          </span>
                        </div>
                      </span>
                    </div>
                  </el-tab-pane>
                </el-tabs>
              </div>

              <div class="wuxinghsu">

                <div class="title">
                  五行数量
                </div>

                <div class="switch">
                  <el-switch
                    v-model="cangGanWuXingSwitch"
                    inline-prompt
                    :active-value="1"
                    :inactive-value="0"
                    active-text="包含藏干"
                    inactive-text="不包含藏干"
                    width="100"
                  />
                </div>

                <div class="divider">
                  <el-divider />
                </div>

                <div class="progress">
                  <Progress
                      :percent="muCount * 10"
                      :stroke-width="20"
                      :stroke-color="muColor"
                    >
                      <span class="count">{{ muCount }}<span v-html="wuXingGaoLiangMethod('木')"></span></span>
                    </Progress>
                </div>
                <div class="progress">
                  <Progress
                      :percent="huoCount * 10"
                      :stroke-width="20"
                      :stroke-color="huoColor"
                    >
                      <span class="count">{{ huoCount }}<span v-html="wuXingGaoLiangMethod('火')"></span></span>
                    </Progress>
                </div>
                <div class="progress">
                  <Progress
                      :percent="tuCount * 10"
                      :stroke-width="20"
                      :stroke-color="tuColor"
                    >
                      <span class="count">{{ tuCount }}<span v-html="wuXingGaoLiangMethod('土')"></span></span>
                    </Progress>
                </div>
                <div class="progress">
                  <Progress
                      :percent="jinCount * 10"
                      :stroke-width="20"
                      :stroke-color="jinColor"
                    >
                      <span class="count">{{ jinCount }}<span v-html="wuXingGaoLiangMethod('金')"></span></span>
                    </Progress>
                </div>
                <div class="progress">
                  <Progress
                      :percent="shuiCount * 10"
                      :stroke-width="20"
                      :stroke-color="shuiColor"
                    >
                      <span class="count">{{ shuiCount }}<span v-html="wuXingGaoLiangMethod('水')"></span></span>
                    </Progress>
                </div>
              </div>

              <div
                class="wangshuai"
                v-if="data.wuXingWangShuai"
              >
                <div class="item">
                  <b
                    class="title"
                    v-html="wuXingGaoLiangMethod2(data.wuXingWangShuai[0])"
                  ></b>
                </div>
                <div class="item">
                  <b
                    class="title"
                    v-html="wuXingGaoLiangMethod2(data.wuXingWangShuai[1])"
                  ></b>
                </div>
                <div class="item">
                  <b
                    class="title"
                    v-html="wuXingGaoLiangMethod2(data.wuXingWangShuai[2])"
                  ></b>
                </div>
                <div class="item">
                  <b
                    class="title"
                    v-html="wuXingGaoLiangMethod2(data.wuXingWangShuai[3])"
                  ></b>
                </div>
                <div class="item">
                  <!-- <Trend
                      class="title"
                      flag="down"
                      reverse-color
                    >
                      <b v-html="wuXingGaoLiangMethod2(data.wuXingWangShuai[4])"></b>
                    </Trend> -->
                  <b
                    class="title"
                    v-html="wuXingGaoLiangMethod2(data.wuXingWangShuai[4])"
                  ></b>
                </div>
              </div>

              <div class="ganzhiguanxi">
                <div class="mb ml">
                  <span class="title">天干关系：</span>
                  <span v-if="data.tianGanLiuYi.length !== 0">
                    {{ data.tianGanLiuYi.join('、') }}
                  </span>
                  <span
                      v-else
                      class="null"
                    >无数据</span>
                </div>
                <div class="ml">
                  <span
                    class="title"
                    @click="ganZhiTuJieMethod(1)"
                  >地支关系：</span>
                  <span v-if="data.diZhiLiuYi.length !== 0">
                    {{ data.diZhiLiuYi.join('、') }}
                  </span>
                    <span
                      v-else
                      class="null"
                    >无数据</span>
                </div>
              </div>

            </div>

            <!-- 命盘信息 -->
            <div
              class="mingpan"
              v-if="dataPage === 2"
            >
              <Row :gutter="10">
                <Col span="13">
                <div
                  class="mingpan-left"
                  v-if="isDaYunData"
                >

                  <div class="go bgi1">
                    <div class="item">
                      <div class="title"></div>
                    </div>
                    <div class="item">
                      <div class="title">年柱</div>
                    </div>
                    <div class="item">
                      <div class="title">月柱</div>
                    </div>
                    <div class="item">
                      <div class="title">日柱</div>
                    </div>
                    <div class="item">
                      <div class="title">时柱</div>
                    </div>
                    <div
                      class="item borl"
                      v-if="isDaYunMingPan"
                    >
                      <div
                        class="title"
                        v-if="daYunLun === 1"
                      ><b>小运</b></div>
                      <div
                        class="title"
                        v-else
                      ><b>大运</b></div>
                    </div>
                    <div
                      class="item"
                      v-show="isLiuNianMingPan"
                    >
                      <div class="title"><b>流年</b></div>
                    </div>
                    <div
                      class="item"
                      v-show="isLiuYueMingPan"
                    >
                      <div class="title"><b>流月</b></div>
                    </div>
                    <div
                      class="item"
                      v-show="isLiuRiMingPan"
                    >
                      <div class="title"><b>流日</b></div>
                    </div>
                    <div
                      class="item"
                      v-show="isLiuShiMingPan"
                    >
                      <div class="title"><b>流时</b></div>
                    </div>
                    <div
                      class="item borl"
                      v-show="isTaiYuanMingPan"
                    >
                      <div class="title"><b>胎元</b></div>
                    </div>
                    <div
                      class="item"
                      v-show="isTaiXiMingPan"
                    >
                      <div class="title"><b>胎息</b></div>
                    </div>
                    <div
                      class="item"
                      v-show="isMingGongMingPan"
                    >
                      <div class="title"><b>命宫</b></div>
                    </div>
                    <div
                      class="item"
                      v-show="isShenGongMingPan"
                    >
                      <div class="title"><b>身宫</b></div>
                    </div>
                  </div>

                  <div class="go bgi2">
                    <div class="item">
                      <div class="title">主星</div>
                    </div>
                    <div class="item">
                      <div class="content">
                        {{ data.yearGanZhiZhuXing }}
                      </div>
                    </div>
                    <div class="item">
                      <div class="content">
                        {{ data.monthGanZhiZhuXing }}
                      </div>
                    </div>
                    <div class="item">
                      <div class="content">
                        {{ data.dayGanZhiZhuXing }}
                      </div>
                    </div>
                    <div class="item">
                      <div class="content">
                        {{ data.hourGanZhiZhuXing }}
                      </div>
                    </div>
                    <div
                      class="item borl"
                      v-if="isDaYunMingPan"
                    >
                      <div class="content">
                        <span v-if="daYunLun === 1">
                          {{ xiaoYunData[liuNianLun - 1].tianShen }}
                        </span>
                        <span v-else>
                          {{ daYunData[daYunLun - 1].tianShen }}
                        </span>
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isLiuNianMingPan"
                    >
                      <div class="content">
                        {{ liuNianData[liuNianLun - 1].tianShen }}
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isLiuYueMingPan"
                    >
                      <div class="content">
                        {{ liuYueData[liuYueLun - 1].tianShen }}
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isLiuRiMingPan"
                    >
                      <div class="content">
                        {{ liuRiData[liuRiLun - 1].tianShen }}
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isLiuShiMingPan"
                    >
                      <div class="content">
                        {{ liuShiData[liuShiLun - 1].tianShen }}
                      </div>
                    </div>
                    <div
                      class="item borl"
                      v-if="isTaiYuanMingPan"
                    >
                      <div class="content">
                        {{ data.taiYuanGanZhiZhuXing }}
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isTaiXiMingPan"
                    >
                      <div class="content">
                        {{ data.taiXiGanZhiZhuXing }}
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isMingGongMingPan"
                    >
                      <div class="content">
                        {{ data.mingGongGanZhiZhuXing }}
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isShenGongMingPan"
                    >
                      <div class="content">
                        {{ data.shenGongGanZhiZhuXing }}
                      </div>
                    </div>
                  </div>

                  <div class="go bgi1">
                    <div class="item">
                      <div class="title">天干</div>
                    </div>
                    <div class="item">
                      <div class="content">
                        <b
                          class="ganzhi"
                          v-html="ganZhiGaoLiangMethod(data.yearGan)"
                        ></b>
                        <span v-html="ganZhiInWuXingGaoLiangMethod(data.yearGan)"></span>
                      </div>
                    </div>
                    <div class="item">
                      <div class="content">
                        <b
                          class="ganzhi"
                          v-html="ganZhiGaoLiangMethod(data.monthGan)"
                        ></b>
                        <span v-html="ganZhiInWuXingGaoLiangMethod(data.monthGan)"></span>
                      </div>
                    </div>
                    <div class="item">
                      <div class="content">
                        <b
                          class="ganzhi"
                          v-html="ganZhiGaoLiangMethod(data.dayGan)"
                        ></b>
                        <span v-html="ganZhiInWuXingGaoLiangMethod(data.dayGan)"></span>
                      </div>
                    </div>
                    <div class="item">
                      <div class="content">
                        <b
                          class="ganzhi"
                          v-html="ganZhiGaoLiangMethod(data.hourGan)"
                        ></b>
                        <span v-html="ganZhiInWuXingGaoLiangMethod(data.hourGan)"></span>
                      </div>
                    </div>
                    <div
                      class="item borl"
                      v-if="isDaYunMingPan"
                    >
                      <div class="content">
                        <span v-if="daYunLun === 1">
                          <b
                            class="ganzhi"
                            v-html="ganZhiGaoLiangMethod(xiaoYunData[liuNianLun - 1].ganZhi.substring(0, 1))"
                          >
                          </b>
                          <span v-html="ganZhiInWuXingGaoLiangMethod(xiaoYunData[liuNianLun - 1].ganZhi.substring(0, 1))"></span>
                        </span>
                        <span v-else>
                          <b
                            class="ganzhi"
                            v-html="ganZhiGaoLiangMethod(daYunData[daYunLun - 1].ganZhi.substring(0, 1))"
                          >
                          </b>
                          <span v-html="ganZhiInWuXingGaoLiangMethod(daYunData[daYunLun - 1].ganZhi.substring(0, 1))"></span>
                        </span>
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isLiuNianMingPan"
                    >
                      <div class="content">
                        <b
                          class="ganzhi"
                          v-html="ganZhiGaoLiangMethod(liuNianData[liuNianLun - 1].ganZhi.substring(0, 1))"
                        ></b>
                        <span v-html="ganZhiInWuXingGaoLiangMethod(liuNianData[liuNianLun - 1].ganZhi.substring(0, 1))"></span>
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isLiuYueMingPan"
                    >
                      <div class="content">
                        <b
                          class="ganzhi"
                          v-html="ganZhiGaoLiangMethod(liuYueData[liuYueLun - 1].ganZhi.substring(0, 1))"
                        ></b>
                        <span v-html="ganZhiInWuXingGaoLiangMethod(liuYueData[liuYueLun - 1].ganZhi.substring(0, 1))"></span>
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isLiuRiMingPan"
                    >
                      <div class="content">
                        <b
                          class="ganzhi"
                          v-html="ganZhiGaoLiangMethod(liuRiData[liuRiLun - 1].ganZhi.substring(0, 1))"
                        ></b>
                        <span v-html="ganZhiInWuXingGaoLiangMethod(liuRiData[liuRiLun - 1].ganZhi.substring(0, 1))"></span>
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isLiuShiMingPan"
                    >
                      <div class="content">
                        <b
                          class="ganzhi"
                          v-html="ganZhiGaoLiangMethod(liuShiData[liuShiLun - 1].ganZhi.substring(0, 1))"
                        ></b>
                        <span v-html="ganZhiInWuXingGaoLiangMethod(liuShiData[liuShiLun - 1].ganZhi.substring(0, 1))"></span>
                      </div>
                    </div>
                    <div
                      class="item borl"
                      v-if="isTaiYuanMingPan"
                    >
                      <div class="content">
                        <b
                          class="ganzhi"
                          v-html="ganZhiGaoLiangMethod(data.taiYuanGan)"
                        ></b>
                        <span v-html="ganZhiInWuXingGaoLiangMethod(data.taiYuanGan)"></span>
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isTaiXiMingPan"
                    >
                      <div class="content">
                        <b
                          class="ganzhi"
                          v-html="ganZhiGaoLiangMethod(data.taiXiGan)"
                        ></b>
                        <span v-html="ganZhiInWuXingGaoLiangMethod(data.taiXiGan)"></span>
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isMingGongMingPan"
                    >
                      <div class="content">
                        <b
                          class="ganzhi"
                          v-html="ganZhiGaoLiangMethod(data.mingGongGan)"
                        ></b>
                        <span v-html="ganZhiInWuXingGaoLiangMethod(data.mingGongGan)"></span>
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isShenGongMingPan"
                    >
                      <div class="content">
                        <b
                          class="ganzhi"
                          v-html="ganZhiGaoLiangMethod(data.shenGongGan)"
                        ></b>
                        <span v-html="ganZhiInWuXingGaoLiangMethod(data.shenGongGan)"></span>
                      </div>
                    </div>
                  </div>

                  <div class="go bgi2">
                    <div class="item">
                      <div class="title">地支</div>
                    </div>
                    <div class="item">
                      <div class="content">
                        <b
                          class="ganzhi"
                          v-html="ganZhiGaoLiangMethod(data.yearZhi)"
                        ></b>
                        <span v-html="ganZhiInWuXingGaoLiangMethod(data.yearZhi)"></span>
                      </div>
                    </div>
                    <div class="item">
                      <div class="content">
                        <b
                          class="ganzhi"
                          v-html="ganZhiGaoLiangMethod(data.monthZhi)"
                        ></b>
                        <span v-html="ganZhiInWuXingGaoLiangMethod(data.monthZhi)"></span>
                      </div>
                    </div>
                    <div class="item">
                      <div class="content">
                        <b
                          class="ganzhi"
                          v-html="ganZhiGaoLiangMethod(data.dayZhi)"
                        ></b>
                        <span v-html="ganZhiInWuXingGaoLiangMethod(data.dayZhi)"></span>
                      </div>
                    </div>
                    <div class="item">
                      <div class="content">
                        <b
                          class="ganzhi"
                          v-html="ganZhiGaoLiangMethod(data.hourZhi)"
                        ></b>
                        <span v-html="ganZhiInWuXingGaoLiangMethod(data.hourZhi)"></span>
                      </div>
                    </div>
                    <div
                      class="item borl"
                      v-if="isDaYunMingPan"
                    >
                      <div class="content">
                        <span v-if="daYunLun === 1">
                          <b
                            class="ganzhi"
                            v-html="ganZhiGaoLiangMethod(xiaoYunData[liuNianLun - 1].ganZhi.substring(1, 2))"
                          >
                          </b>
                          <span v-html="ganZhiInWuXingGaoLiangMethod(xiaoYunData[liuNianLun - 1].ganZhi.substring(1, 2))"></span>
                        </span>
                        <span v-else>
                          <b
                            class="ganzhi"
                            v-html="ganZhiGaoLiangMethod(daYunData[daYunLun - 1].ganZhi.substring(1, 2))"
                          >
                          </b>
                          <span v-html="ganZhiInWuXingGaoLiangMethod(daYunData[daYunLun - 1].ganZhi.substring(1, 2))"></span>
                        </span>
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isLiuNianMingPan"
                    >
                      <div class="content">
                        <b
                          class="ganzhi"
                          v-html="ganZhiGaoLiangMethod(liuNianData[liuNianLun - 1].ganZhi.substring(1, 2))"
                        ></b>
                        <span v-html="ganZhiInWuXingGaoLiangMethod(liuNianData[liuNianLun - 1].ganZhi.substring(1, 2))"></span>
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isLiuYueMingPan"
                    >
                      <div class="content">
                        <b
                          class="ganzhi"
                          v-html="ganZhiGaoLiangMethod(liuYueData[liuYueLun - 1].ganZhi.substring(1, 2))"
                        ></b>
                        <span v-html="ganZhiInWuXingGaoLiangMethod(liuYueData[liuYueLun - 1].ganZhi.substring(1, 2))"></span>
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isLiuRiMingPan"
                    >
                      <div class="content">
                        <b
                          class="ganzhi"
                          v-html="ganZhiGaoLiangMethod(liuRiData[liuRiLun - 1].ganZhi.substring(1, 2))"
                        ></b>
                        <span v-html="ganZhiInWuXingGaoLiangMethod(liuRiData[liuRiLun - 1].ganZhi.substring(1, 2))"></span>
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isLiuShiMingPan"
                    >
                      <div class="content">
                        <b
                          class="ganzhi"
                          v-html="ganZhiGaoLiangMethod(liuShiData[liuShiLun - 1].ganZhi.substring(1, 2))"
                        ></b>
                        <span v-html="ganZhiInWuXingGaoLiangMethod(liuShiData[liuShiLun - 1].ganZhi.substring(1, 2))"></span>
                      </div>
                    </div>
                    <div
                      class="item borl"
                      v-if="isTaiYuanMingPan"
                    >
                      <div class="content">
                        <b
                          class="ganzhi"
                          v-html="ganZhiGaoLiangMethod(data.taiYuanZhi)"
                        ></b>
                        <span v-html="ganZhiInWuXingGaoLiangMethod(data.taiYuanZhi)"></span>
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isTaiXiMingPan"
                    >
                      <div class="content">
                        <b
                          class="ganzhi"
                          v-html="ganZhiGaoLiangMethod(data.taiXiGanZhi.substring(1, 2))"
                        ></b>
                        <span v-html="ganZhiInWuXingGaoLiangMethod(data.taiXiGanZhi.substring(1, 2))"></span>
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isMingGongMingPan"
                    >
                      <div class="content">
                        <b
                          class="ganzhi"
                          v-html="ganZhiGaoLiangMethod(data.mingGongGanZhi.substring(1, 2))"
                        ></b>
                        <span v-html="ganZhiInWuXingGaoLiangMethod(data.mingGongGanZhi.substring(1, 2))"></span>
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isShenGongMingPan"
                    >
                      <div class="content">
                        <b
                          class="ganzhi"
                          v-html="ganZhiGaoLiangMethod(data.shenGongGanZhi.substring(1, 2))"
                        ></b>
                        <span v-html="ganZhiInWuXingGaoLiangMethod(data.shenGongGanZhi.substring(1, 2))"></span>
                      </div>
                    </div>
                  </div>

                  <div class="go bgi1">
                    <div class="item">
                      <div class="title">藏干</div>
                    </div>
                    <div class="item">
                      <div class="content">
                        <div
                          v-for="index in data.yearZhiCangGan.length"
                          :key="index"
                          class="canggan"
                        >
                          <b v-html="ganZhiGaoLiangMethod(data.yearZhiCangGan[index - 1])"></b>
                          <span v-html="ganZhiInWuXingGaoLiangMethod(data.yearZhiCangGan[index - 1])"></span>
                        </div>
                      </div>
                    </div>
                    <div class="item">
                      <div class="content">
                        <div
                          v-for="index in data.monthZhiCangGan.length"
                          :key="index"
                          class="canggan"
                        >
                          <b v-html="ganZhiGaoLiangMethod(data.monthZhiCangGan[index - 1])"></b>
                          <span v-html="ganZhiInWuXingGaoLiangMethod(data.monthZhiCangGan[index - 1])"></span>
                        </div>
                      </div>
                    </div>
                    <div class="item">
                      <div class="content">
                        <div
                          v-for="index in data.dayZhiCangGan.length"
                          :key="index"
                          class="canggan"
                        >
                          <b v-html="ganZhiGaoLiangMethod(data.dayZhiCangGan[index - 1])"></b>
                          <span v-html="ganZhiInWuXingGaoLiangMethod(data.dayZhiCangGan[index - 1])"></span>
                        </div>
                      </div>
                    </div>
                    <div class="item">
                      <div class="content">
                        <div
                          v-for="index in data.hourZhiCangGan.length"
                          :key="index"
                          class="canggan"
                        >
                          <b v-html="ganZhiGaoLiangMethod(data.hourZhiCangGan[index - 1])"></b>
                          <span v-html="ganZhiInWuXingGaoLiangMethod(data.hourZhiCangGan[index - 1])"></span>
                        </div>
                      </div>
                    </div>
                    <div
                      class="item borl"
                      v-if="isDaYunMingPan"
                    >
                      <div class="content">
                        <span v-if="daYunLun === 1">
                          <div
                            v-for="item in xiaoYunData[liuNianLun - 1].cangGan.split('-')"
                            :key="item"
                            class="canggan"
                          >
                            <b v-html="ganZhiGaoLiangMethod(item)"></b>
                            <span v-html="ganZhiInWuXingGaoLiangMethod(item)"></span>
                          </div>
                        </span>
                        <span v-else>
                          <div
                            v-for="item in daYunData[daYunLun - 1].cangGan.split('-')"
                            :key="item"
                            class="canggan"
                          >
                            <b v-html="ganZhiGaoLiangMethod(item)"></b>
                            <span v-html="ganZhiInWuXingGaoLiangMethod(item)"></span>
                          </div>
                        </span>
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isLiuNianMingPan"
                    >
                      <div class="content">
                        <div
                          v-for="item in liuNianData[liuNianLun - 1].cangGan.split('-')"
                          :key="item"
                          class="canggan"
                        >
                          <b v-html="ganZhiGaoLiangMethod(item)"></b>
                          <span v-html="ganZhiInWuXingGaoLiangMethod(item)"></span>
                        </div>
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isLiuYueMingPan"
                    >
                      <div class="content">
                        <div
                          v-for="item in liuYueData[liuYueLun - 1].cangGan.split('-')"
                          :key="item"
                          class="canggan"
                        >
                          <b v-html="ganZhiGaoLiangMethod(item)"></b>
                          <span v-html="ganZhiInWuXingGaoLiangMethod(item)"></span>
                        </div>
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isLiuRiMingPan"
                    >
                      <div class="content">
                        <div
                          v-for="item in liuRiData[liuRiLun - 1].cangGan.split('-')"
                          :key="item"
                          class="canggan"
                        >
                          <b v-html="ganZhiGaoLiangMethod(item)"></b>
                          <span v-html="ganZhiInWuXingGaoLiangMethod(item)"></span>
                        </div>
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isLiuShiMingPan"
                    >
                      <div class="content">
                        <div
                          v-for="item in liuShiData[liuShiLun - 1].cangGan.split('-')"
                          :key="item"
                          class="canggan"
                        >
                          <b v-html="ganZhiGaoLiangMethod(item)"></b>
                          <span v-html="ganZhiInWuXingGaoLiangMethod(item)"></span>
                        </div>
                      </div>
                    </div>
                    <div
                      class="item borl"
                      v-if="isTaiYuanMingPan"
                    >
                      <div class="content">
                        <div
                          v-for="item in data.taiYuanZhiCangGan"
                          :key="item"
                          class="canggan"
                        >
                          <b v-html="ganZhiGaoLiangMethod(item)"></b>
                          <span v-html="ganZhiInWuXingGaoLiangMethod(item)"></span>
                        </div>
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isTaiXiMingPan"
                    >
                      <div class="content">
                        <div
                          v-for="item in data.taiXiZhiCangGan"
                          :key="item"
                          class="canggan"
                        >
                          <b v-html="ganZhiGaoLiangMethod(item)"></b>
                          <span v-html="ganZhiInWuXingGaoLiangMethod(item)"></span>
                        </div>
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isMingGongMingPan"
                    >
                      <div class="content">
                        <div
                          v-for="item in data.mingGongZhiCangGan"
                          :key="item"
                          class="canggan"
                        >
                          <b v-html="ganZhiGaoLiangMethod(item)"></b>
                          <span v-html="ganZhiInWuXingGaoLiangMethod(item)"></span>
                        </div>
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isShenGongMingPan"
                    >
                      <div class="content">
                        <div
                          v-for="item in data.shenGongZhiCangGan"
                          :key="item"
                          class="canggan"
                        >
                          <b v-html="ganZhiGaoLiangMethod(item)"></b>
                          <span v-html="ganZhiInWuXingGaoLiangMethod(item)"></span>
                        </div>
                      </div>
                    </div>
                  </div>

                  <div class="go bgi2">
                    <div class="item">
                      <div class="title">副星</div>
                    </div>
                    <div class="item">
                      <div class="content">
                        <div
                          v-for="index in data.yearGanZhiFuXing.length"
                          :key="index"
                          class="fuxing"
                        >
                          {{ data.yearGanZhiFuXing[index - 1] }} <br />
                        </div>
                      </div>
                    </div>
                    <div class="item">
                      <div class="content">
                        <div
                          v-for="index in data.monthGanZhiFuXing.length"
                          :key="index"
                          class="fuxing"
                        >
                          {{ data.monthGanZhiFuXing[index - 1] }} <br />
                        </div>
                      </div>
                    </div>
                    <div class="item">
                      <div class="content">
                        <div
                          v-for="index in data.dayGanZhiFuXing.length"
                          :key="index"
                          class="fuxing"
                        >
                          {{ data.dayGanZhiFuXing[index - 1] }} <br />
                        </div>
                      </div>
                    </div>
                    <div class="item">
                      <div class="content">
                        <div
                          v-for="index in data.hourGanZhiFuXing.length"
                          :key="index"
                          class="fuxing"
                        >
                          {{ data.hourGanZhiFuXing[index - 1] }} <br />
                        </div>
                      </div>
                    </div>
                    <div
                      class="item borl"
                      v-if="isDaYunMingPan"
                    >
                      <div class="content">
                        <span v-if="daYunLun === 1">
                          <div
                            v-for="item in xiaoYunData[liuNianLun - 1].fuXing.split('-')"
                            :key="item"
                            class="fuxing"
                          >
                            {{ item }}
                          </div>
                        </span>
                        <span v-else>
                          <div
                            v-for="item in daYunData[daYunLun - 1].fuXing.split('-')"
                            :key="item"
                            class="fuxing"
                          >
                            {{ item }}
                          </div>
                        </span>
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isLiuNianMingPan"
                    >
                      <div class="content">
                        <div
                          v-for="item in liuNianData[liuNianLun - 1].fuXing.split('-')"
                          :key="item"
                          class="fuxing"
                        >
                          {{ item }}
                        </div>
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isLiuYueMingPan"
                    >
                      <div class="content">
                        <div
                          v-for="item in liuYueData[liuYueLun - 1].fuXing.split('-')"
                          :key="item"
                          class="fuxing"
                        >
                          {{ item }}
                        </div>
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isLiuRiMingPan"
                    >
                      <div class="content">
                        <div
                          v-for="item in liuRiData[liuRiLun - 1].fuXing.split('-')"
                          :key="item"
                          class="fuxing"
                        >
                          {{ item }}
                        </div>
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isLiuShiMingPan"
                    >
                      <div class="content">
                        <div
                          v-for="item in liuShiData[liuShiLun - 1].fuXing.split('-')"
                          :key="item"
                          class="fuxing"
                        >
                          {{ item }}
                        </div>
                      </div>
                    </div>
                    <div
                      class="item borl"
                      v-if="isTaiYuanMingPan"
                    >
                      <div class="content">
                        <div
                          v-for="item in data.taiYuanGanZhiFuXing"
                          :key="item"
                          class="fuxing"
                        >
                          {{ item }}
                        </div>
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isTaiXiMingPan"
                    >
                      <div class="content">
                        <div
                          v-for="item in data.taiXiGanZhiFuXing"
                          :key="item"
                          class="fuxing"
                        >
                          {{ item }}
                        </div>
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isMingGongMingPan"
                    >
                      <div class="content">
                        <div
                          v-for="item in data.mingGongGanZhiFuXing"
                          :key="item"
                          class="fuxing"
                        >
                          {{ item }}
                        </div>
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isShenGongMingPan"
                    >
                      <div class="content">
                        <div
                          v-for="item in data.shenGongGanZhiFuXing"
                          :key="item"
                          class="fuxing"
                        >
                          {{ item }}
                        </div>
                      </div>
                    </div>
                  </div>

                  <div class="go bgi1">
                    <div class="item">
                      <div class="title">自坐</div>
                    </div>
                    <div class="item">
                      <div class="content">
                        {{ data.yearGanZhiZiZuo }}
                      </div>
                    </div>
                    <div class="item">
                      <div class="content">
                        {{ data.monthGanZhiZiZuo }}
                      </div>
                    </div>
                    <div class="item">
                      <div class="content">
                        {{ data.dayGanZhiZiZuo }}
                      </div>
                    </div>
                    <div class="item">
                      <div class="content">
                        {{ data.hourGanZhiZiZuo }}
                      </div>
                    </div>
                    <div
                      class="item borl"
                      v-if="isDaYunMingPan"
                    >
                      <div class="content">
                        <span v-if="daYunLun === 1">
                          {{ xiaoYunData[liuNianLun - 1].ziZuo }}
                        </span>
                        <span v-else>
                          {{ daYunData[daYunLun - 1].ziZuo }}
                        </span>
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isLiuNianMingPan"
                    >
                      <div class="content">
                        {{ liuNianData[liuNianLun - 1].ziZuo }}
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isLiuYueMingPan"
                    >
                      <div class="content">
                        {{ liuYueData[liuYueLun - 1].ziZuo }}
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isLiuRiMingPan"
                    >
                      <div class="content">
                        {{ liuRiData[liuRiLun - 1].ziZuo }}
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isLiuShiMingPan"
                    >
                      <div class="content">
                        {{ liuShiData[liuShiLun - 1].ziZuo }}
                      </div>
                    </div>
                    <div
                      class="item borl"
                      v-if="isTaiYuanMingPan"
                    >
                      <div class="content">
                        {{ data.taiYuanGanZhiZiZuo }}
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isTaiXiMingPan"
                    >
                      <div class="content">
                        {{ data.taiXiGanZhiZiZuo }}
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isMingGongMingPan"
                    >
                      <div class="content">
                        {{ data.mingGongGanZhiZiZuo }}
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isShenGongMingPan"
                    >
                      <div class="content">
                        {{ data.shenGongGanZhiZiZuo }}
                      </div>
                    </div>
                  </div>

                  <div class="go bgi2">
                    <div class="item">
                      <div class="title">星运</div>
                    </div>
                    <div class="item">
                      <div class="content">
                        {{ data.yearGanZhiXingYun }}
                      </div>
                    </div>
                    <div class="item">
                      <div class="content">
                        {{ data.monthGanZhiXingYun }}
                      </div>
                    </div>
                    <div class="item">
                      <div class="content">
                        {{ data.dayGanZhiXingYun }}
                      </div>
                    </div>
                    <div class="item">
                      <div class="content">
                        {{ data.hourGanZhiXingYun }}
                      </div>
                    </div>
                    <div
                      class="item borl"
                      v-if="isDaYunMingPan"
                    >
                      <div class="content">
                        <span v-if="daYunLun === 1">
                          {{ xiaoYunData[liuNianLun - 1].xingYun }}
                        </span>
                        <span v-else>
                          {{ daYunData[daYunLun - 1].xingYun }}
                        </span>
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isLiuNianMingPan"
                    >
                      <div class="content">
                        {{ liuNianData[liuNianLun - 1].xingYun }}
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isLiuYueMingPan"
                    >
                      <div class="content">
                        {{ liuYueData[liuYueLun - 1].xingYun }}
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isLiuRiMingPan"
                    >
                      <div class="content">
                        {{ liuRiData[liuRiLun - 1].xingYun }}
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isLiuShiMingPan"
                    >
                      <div class="content">
                        {{ liuShiData[liuShiLun - 1].xingYun }}
                      </div>
                    </div>
                    <div
                      class="item borl"
                      v-if="isTaiYuanMingPan"
                    >
                      <div class="content">
                        {{ data.taiYuanGanZhiXingYun }}
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isTaiXiMingPan"
                    >
                      <div class="content">
                        {{ data.taiXiGanZhiXingYun }}
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isMingGongMingPan"
                    >
                      <div class="content">
                        {{ data.mingGongGanZhiXingYun }}
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isShenGongMingPan"
                    >
                      <div class="content">
                        {{ data.shenGongGanZhiXingYun }}
                      </div>
                    </div>
                  </div>

                  <div class="go bgi1">
                    <div class="item">
                      <div class="title">空亡</div>
                    </div>
                    <div class="item">
                      <div class="content">
                        <span v-html="ganZhiGaoLiangMethod(data.yearGanZhiKongWang.substring(0, 1))"></span>
                        <span v-html="ganZhiGaoLiangMethod(data.yearGanZhiKongWang.substring(1, 2))"></span>
                      </div>
                    </div>
                    <div class="item">
                      <div class="content">
                        <span v-html="ganZhiGaoLiangMethod(data.monthGanZhiKongWang.substring(0, 1))"></span>
                        <span v-html="ganZhiGaoLiangMethod(data.monthGanZhiKongWang.substring(1, 2))"></span>
                      </div>
                    </div>
                    <div class="item">
                      <div class="content">
                        <span v-html="ganZhiGaoLiangMethod(data.dayGanZhiKongWang.substring(0, 1))"></span>
                        <span v-html="ganZhiGaoLiangMethod(data.dayGanZhiKongWang.substring(1, 2))"></span>
                      </div>
                    </div>
                    <div class="item">
                      <div class="content">
                        <span v-html="ganZhiGaoLiangMethod(data.hourGanZhiKongWang.substring(0, 1))"></span>
                        <span v-html="ganZhiGaoLiangMethod(data.hourGanZhiKongWang.substring(1, 2))"></span>
                      </div>
                    </div>
                    <div
                      class="item borl"
                      v-if="isDaYunMingPan"
                    >
                      <div class="content">
                        <span v-if="daYunLun === 1">
                          <span v-html="ganZhiGaoLiangMethod(xiaoYunData[liuNianLun - 1].kongWang.substring(0, 1))"></span>
                          <span v-html="ganZhiGaoLiangMethod(xiaoYunData[liuNianLun - 1].kongWang.substring(1, 2))"></span>
                        </span>
                        <span v-else>
                          <span v-html="ganZhiGaoLiangMethod(daYunData[daYunLun - 1].kongWang.substring(0, 1))"></span>
                          <span v-html="ganZhiGaoLiangMethod(daYunData[daYunLun - 1].kongWang.substring(1, 2))"></span>
                        </span>

                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isLiuNianMingPan"
                    >
                      <div class="content">
                        <span v-html="ganZhiGaoLiangMethod(liuNianData[liuNianLun - 1].kongWang.substring(0, 1))"></span>
                        <span v-html="ganZhiGaoLiangMethod(liuNianData[liuNianLun - 1].kongWang.substring(1, 2))"></span>
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isLiuYueMingPan"
                    >
                      <div class="content">
                        <span v-html="ganZhiGaoLiangMethod(liuYueData[liuYueLun - 1].kongWang.substring(0, 1))"></span>
                        <span v-html="ganZhiGaoLiangMethod(liuYueData[liuYueLun - 1].kongWang.substring(1, 2))"></span>
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isLiuRiMingPan"
                    >
                      <div class="content">
                        <span v-html="ganZhiGaoLiangMethod(liuRiData[liuYueLun - 1].kongWang.substring(0, 1))"></span>
                        <span v-html="ganZhiGaoLiangMethod(liuRiData[liuYueLun - 1].kongWang.substring(1, 2))"></span>
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isLiuShiMingPan"
                    >
                      <div class="content">
                        <span v-html="ganZhiGaoLiangMethod(liuShiData[liuShiLun - 1].kongWang.substring(0, 1))"></span>
                        <span v-html="ganZhiGaoLiangMethod(liuShiData[liuShiLun - 1].kongWang.substring(1, 2))"></span>
                      </div>
                    </div>
                    <div
                      class="item borl"
                      v-if="isTaiYuanMingPan"
                    >
                      <div class="content">
                        <span v-html="ganZhiGaoLiangMethod(data.taiYuanGanZhiKongWang.substring(0, 1))"></span>
                        <span v-html="ganZhiGaoLiangMethod(data.taiYuanGanZhiKongWang.substring(1, 2))"></span>
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isTaiXiMingPan"
                    >
                      <div class="content">
                        <span v-html="ganZhiGaoLiangMethod(data.taiXiGanZhiKongWang.substring(0, 1))"></span>
                        <span v-html="ganZhiGaoLiangMethod(data.taiXiGanZhiKongWang.substring(1, 2))"></span>
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isMingGongMingPan"
                    >
                      <div class="content">
                        <span v-html="ganZhiGaoLiangMethod(data.mingGongGanZhiKongWang.substring(0, 1))"></span>
                        <span v-html="ganZhiGaoLiangMethod(data.mingGongGanZhiKongWang.substring(1, 2))"></span>
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isShenGongMingPan"
                    >
                      <div class="content">
                        <span v-html="ganZhiGaoLiangMethod(data.shenGongGanZhiKongWang.substring(0, 1))"></span>
                        <span v-html="ganZhiGaoLiangMethod(data.shenGongGanZhiKongWang.substring(1, 2))"></span>
                      </div>
                    </div>
                  </div>

                  <div class="go bgi2">
                    <div class="item">
                      <div class="title">纳音</div>
                    </div>
                    <div class="item">
                      <div class="content">
                        {{ data.yearGanZhiNaYin }}
                      </div>
                    </div>
                    <div class="item">
                      <div class="content">
                        {{ data.monthGanZhiNaYin }}
                      </div>
                    </div>
                    <div class="item">
                      <div class="content">
                        {{ data.dayGanZhiNaYin }}
                      </div>
                    </div>
                    <div class="item">
                      <div class="content">
                        {{ data.hourGanZhiNaYin }}
                      </div>
                    </div>
                    <div
                      class="item borl"
                      v-if="isDaYunMingPan"
                    >
                      <div class="content">
                        <span v-if="daYunLun === 1">
                          {{ xiaoYunData[liuNianLun - 1].naYin }}
                        </span>
                        <span v-else>
                          {{ daYunData[daYunLun - 1].naYin }}
                        </span>
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isLiuNianMingPan"
                    >
                      <div class="content">
                        {{ liuNianData[liuNianLun - 1].naYin }}
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isLiuYueMingPan"
                    >
                      <div class="content">
                        {{ liuYueData[liuYueLun - 1].naYin }}
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isLiuRiMingPan"
                    >
                      <div class="content">
                        {{ liuRiData[liuRiLun - 1].naYin }}
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isLiuShiMingPan"
                    >
                      <div class="content">
                        {{ liuShiData[liuShiLun - 1].naYin }}
                      </div>
                    </div>
                    <div
                      class="item borl"
                      v-if="isTaiYuanMingPan"
                    >
                      <div class="content">
                        {{ data.taiYuanGanZhiNaYin }}
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isTaiXiMingPan"
                    >
                      <div class="content">
                        {{ data.taiXiGanZhiNaYin }}
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isMingGongMingPan"
                    >
                      <div class="content">
                        {{ data.mingGongGanZhiNaYin }}
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isShenGongMingPan"
                    >
                      <div class="content">
                        {{ data.shenGongGanZhiNaYin }}
                      </div>
                    </div>
                  </div>

                  <div class="go bgi">
                    <div class="item">
                      <div class="title">神煞</div>
                    </div>
                    <div class="item">
                      <div class="content">
                        <div
                          v-for="index in data.yearGanZhiShenSha.length"
                          :key="index"
                          class="shensha"
                        >
                          {{ data.yearGanZhiShenSha[index - 1] }}
                        </div>
                      </div>
                    </div>
                    <div class="item">
                      <div class="content">
                        <div
                          v-for="index in data.monthGanZhiShenSha.length"
                          :key="index"
                          class="shensha"
                        >
                          {{ data.monthGanZhiShenSha[index - 1] }}
                        </div>
                      </div>
                    </div>
                    <div class="item">
                      <div class="content">
                        <div
                          v-for="index in data.dayGanZhiShenSha.length"
                          :key="index"
                          class="shensha"
                        >
                          {{ data.dayGanZhiShenSha[index - 1] }}
                        </div>
                      </div>
                    </div>
                    <div class="item">
                      <div class="content">
                        <div
                          v-for="index in data.hourGanZhiShenSha.length"
                          :key="index"
                          class="shensha"
                        >
                          {{ data.hourGanZhiShenSha[index - 1] }}
                        </div>
                      </div>
                    </div>
                    <div
                      class="item borl"
                      v-if="isDaYunMingPan"
                    >
                      <div class="content">
                        <span v-if="daYunLun === 1">
                          <div
                            v-for="item in xiaoYunData[liuNianLun - 1].shenSha.split('-')"
                            :key="item"
                            class="shensha"
                          >
                            {{ item }}
                          </div>
                        </span>
                        <span v-else>
                          <div
                            v-for="item in daYunData[daYunLun - 1].shenSha.split('-')"
                            :key="item"
                            class="shensha"
                          >
                            {{ item }}
                          </div>
                        </span>
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isLiuNianMingPan"
                    >
                      <div class="content">
                        <div
                          v-for="item in liuNianData[liuNianLun - 1].shenSha.split('-')"
                          :key="item"
                          class="shensha"
                        >
                          {{ item }}
                        </div>
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isLiuYueMingPan"
                    >
                      <div class="content">
                        <div
                          v-for="item in liuYueData[liuYueLun - 1].shenSha.split('-')"
                          :key="item"
                          class="shensha"
                        >
                          {{ item }}
                        </div>
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isLiuRiMingPan"
                    >
                      <div class="content">
                        <div
                          v-for="item in liuRiData[liuRiLun - 1].shenSha.split('-')"
                          :key="item"
                          class="shensha"
                        >
                          {{ item }}
                        </div>
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isLiuShiMingPan"
                    >
                      <div class="content">
                        <div
                          v-for="item in liuShiData[liuShiLun - 1].shenSha.split('-')"
                          :key="item"
                          class="shensha"
                        >
                          {{ item }}
                        </div>
                      </div>
                    </div>
                    <div
                      class="item borl"
                      v-if="isTaiYuanMingPan"
                    >
                      <div class="content">
                        <div
                          v-for="item in data.taiYuanGanZhiShenSha"
                          :key="item"
                          class="shensha"
                        >
                          {{ item }}
                        </div>
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isTaiXiMingPan"
                    >
                      <div class="content">
                        <div
                          v-for="item in data.taiXiGanZhiShenSha"
                          :key="item"
                          class="shensha"
                        >
                          {{ item }}
                        </div>
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isMingGongMingPan"
                    >
                      <div class="content">
                        <div
                          v-for="item in data.mingGongGanZhiShenSha"
                          :key="item"
                          class="shensha"
                        >
                          {{ item }}
                        </div>
                      </div>
                    </div>
                    <div
                      class="item"
                      v-if="isShenGongMingPan"
                    >
                      <div class="content">
                        <div
                          v-for="item in data.shenGongGanZhiShenSha"
                          :key="item"
                          class="shensha"
                        >
                          {{ item }}
                        </div>
                      </div>
                    </div>
                  </div>

                </div>
                </Col>
                <Col span="11">
                <div
                  class="mingpan-right"
                  v-if="isDaYunData"
                >

                  <div class="qiyun">
                    <div><span class="title">起运：</span>{{ data.solarQiYun }}</div>
                    <div><span class="title">交运：</span>{{ data.solarJiaoYun }}</div>
                    <div class="mingpanmode">
                      <div>
                        <el-segmented
                          class="segmented3"
                          v-model="mingPanModeStr"
                          :options="mingPanModeOptions"
                          @change="mingPanQieHuaMethod"
                        />
                      </div>
                    </div>
                  </div>

                  <div class="max-height">

                    <div class="daYunLiuNianMode">
                      <el-switch
                        class="switch"
                        v-model="daYunLiuNianMode"
                        inline-prompt
                        :active-value="2"
                        :inactive-value="1"
                        active-text="精"
                        inactive-text="简"
                        style="--el-switch-on-color:#19be6b;--el-switch-off-color:#2d8cf0;"
                      />
                    </div>

                    <!-- 标准模式 -->
                    <div v-if="daYunLiuNianMode === 1">

                      <div class="dayunliunian1">

                        <div
                          class="title cursor"
                          @click="daYunLiuNianModeMethod"
                        >
                          <div class="item">
                            <b>大<br />运</b>
                          </div>
                        </div>

                        <div class="content">
                          <div class="item">
                            <span
                              v-for="index in daYunData.length"
                              :key="index"
                            >
                              <span v-if="daYunLun === index">
                                <div class="one-yes">
                                  <div class="age">{{ daYunData[index - 1].age }}岁</div>
                                  <div class="year">{{ daYunData[index - 1].solarYear }}年</div>
                                  <span v-if="index !== 1">
                                    <div class="ganZhi">
                                      <span v-html="ganZhiGaoLiangMethod2(daYunData[index - 1].ganZhi)"></span>
                                    </div>
                                    <div class="shiShen">
                                      <div class="l">
                                        {{ daYunData[index - 1].tianShen.substring(0, 1) }}<br />{{ daYunData[index -
                                        1].tianShen.substring(1, 2) }}
                                      </div>
                                      <div class="r">
                                        {{ daYunData[index - 1].diShen.substring(0, 1) }}<br />{{ daYunData[index -
                                        1].diShen.substring(1, 2) }}
                                      </div>
                                    </div>
                                  </span>
                                  <span v-else>
                                    <div class="xiaoyun">小<br />运</div>
                                  </span>
                                </div>
                              </span>
                              <span v-else>
                                <div
                                  class="one-no"
                                  @click="daYunMethod(index, daYunData[index - 1].ganZhi, daYunData[index - 1].solarDate)"
                                >
                                  <div class="age">{{ daYunData[index - 1].age }}岁</div>
                                  <div class="year">{{ daYunData[index - 1].solarYear }}年</div>
                                  <span v-if="index != 1">
                                    <div class="ganZhi">
                                      <span v-html="ganZhiGaoLiangMethod2(daYunData[index - 1].ganZhi)"></span>
                                    </div>
                                    <div class="shiShen">
                                      <div class="l">
                                        {{ daYunData[index - 1].tianShen.substring(0, 1) }}<br />{{ daYunData[index -
                                        1].tianShen.substring(1, 2) }}
                                      </div>
                                      <div class="r">
                                        {{ daYunData[index - 1].diShen.substring(0, 1) }}<br />{{ daYunData[index -
                                        1].diShen.substring(1, 2) }}
                                      </div>
                                    </div>
                                  </span>
                                  <span v-else>
                                    <div class="xiaoyun">小<br />运</div>
                                  </span>
                                </div>
                              </span>
                            </span>
                          </div>
                        </div>

                      </div>

                      <div class="dayunliunian1">
                        <div class="title">
                          <div class="item"><b>流<br />年</b></div>
                        </div>
                        <div class="content">
                          <div class="item">
                            <span
                              v-for="index in liuNianData.length"
                              :key="index"
                            >
                              <span v-if="liuNianLun === index">
                                <div class="one-yes">
                                  <div class="age">{{ liuNianData[index - 1].age }}岁</div>
                                  <div class="year">{{ liuNianData[index - 1].solarYear }}年</div>
                                  <div class="ganZhi">
                                    <span v-html="ganZhiGaoLiangMethod2(liuNianData[index - 1].ganZhi)"></span>
                                  </div>
                                  <div class="shiShen">
                                    <div class="l">
                                      {{ liuNianData[index - 1].tianShen.substring(0, 1) }}<br />{{ liuNianData[index -
                                      1].tianShen.substring(1, 2) }}
                                    </div>
                                    <div class="r">
                                      {{ liuNianData[index - 1].diShen.substring(0, 1) }}<br />{{ liuNianData[index -
                                      1].diShen.substring(1, 2) }}
                                    </div>
                                  </div>
                                </div>
                              </span>
                              <span v-else>
                                <div
                                  class="one-no"
                                  @click="liuNianMethod(index, liuNianData[index - 1].ganZhi, liuNianData[index - 1].solarDate)"
                                >
                                  <div class="age">{{ liuNianData[index - 1].age }}岁</div>
                                  <div class="year">{{ liuNianData[index - 1].solarYear }}年</div>
                                  <div class="ganZhi">
                                    <span v-html="ganZhiGaoLiangMethod2(liuNianData[index - 1].ganZhi)"></span>
                                  </div>
                                  <div class="shiShen">
                                    <div class="l">
                                      {{ liuNianData[index - 1].tianShen.substring(0, 1) }}<br />{{ liuNianData[index -
                                      1].tianShen.substring(1, 2) }}
                                    </div>
                                    <div class="r">
                                      {{ liuNianData[index - 1].diShen.substring(0, 1) }}<br />{{ liuNianData[index -
                                      1].diShen.substring(1, 2) }}
                                    </div>
                                  </div>
                                </div>
                              </span>
                            </span>
                          </div>
                        </div>
                      </div>

                      <div class="xiaoyun1">
                        <div class="title">
                          <div class="item"><b>小<br />运</b></div>
                        </div>
                        <div class="content">
                          <div class="item">
                            <span
                              v-for="index in xiaoYunData.length"
                              :key="index"
                            >
                              <span v-if="liuNianLun === index">
                                <div class="one-yes">
                                  <div class="ganZhi">
                                    <span v-html="ganZhiGaoLiangMethod2(xiaoYunData[index - 1].ganZhi)"></span>
                                  </div>
                                  <div class="shiShen">
                                    <div class="l">
                                      {{ xiaoYunData[index - 1].tianShen.substring(0, 1) }}<br />{{ xiaoYunData[index -
                                      1].tianShen.substring(1, 2) }}
                                    </div>
                                    <div class="r">
                                      {{ xiaoYunData[index - 1].diShen.substring(0, 1) }}<br />{{ xiaoYunData[index -
                                      1].diShen.substring(1, 2) }}
                                    </div>
                                  </div>
                                </div>
                              </span>
                              <span v-else>
                                <div
                                  class="one-no"
                                  @click="liuNianMethod(index, liuNianData[index - 1].ganZhi, xiaoYunData[index - 1].solarDate)"
                                >
                                  <div class="ganZhi">
                                    <span v-html="ganZhiGaoLiangMethod2(xiaoYunData[index - 1].ganZhi)"></span>
                                  </div>
                                  <div class="shiShen">
                                    <div class="l">
                                      {{ xiaoYunData[index - 1].tianShen.substring(0, 1) }}<br />{{ xiaoYunData[index -
                                      1].tianShen.substring(1, 2) }}
                                    </div>
                                    <div class="r">
                                      {{ xiaoYunData[index - 1].diShen.substring(0, 1) }}<br />{{ xiaoYunData[index -
                                      1].diShen.substring(1, 2) }}
                                    </div>
                                  </div>
                                </div>
                              </span>
                            </span>
                          </div>
                        </div>
                      </div>

                      <div class="dayunliunian1">
                        <div class="title">
                          <div class="item"><b>流<br />月</b></div>
                        </div>
                        <div class="content">
                          <div class="item">
                            <span
                              v-for="index in liuYueData.length"
                              :key="index"
                            >
                              <span v-if="liuYueLun === index">
                                <div class="one-yes">
                                  <div class="age2">{{ liuYueData[index - 1].lunarMonth + '/' + liuYueData[index - 1].shiErJie
                                }}</div>
                                  <div class="year">{{ liuYueData[index - 1].solarMonthDay }}</div>
                                  <div class="ganZhi">
                                    <span v-html="ganZhiGaoLiangMethod2(liuYueData[index - 1].ganZhi)"></span>
                                  </div>
                                  <div class="shiShen">
                                    <div class="l">
                                      {{ liuYueData[index - 1].tianShen.substring(0, 1) }}<br />{{ liuYueData[index -
                                      1].tianShen.substring(1, 2) }}
                                    </div>
                                    <div class="r">
                                      {{ liuYueData[index - 1].diShen.substring(0, 1) }}<br />{{ liuYueData[index -
                                      1].diShen.substring(1, 2) }}
                                    </div>
                                  </div>
                                </div>
                              </span>
                              <span v-else>
                                <div
                                  class="one-no"
                                  @click="liuYueMethod(index, liuYueData[index - 1].ganZhi, liuYueData[index - 1].solarDate)"
                                >
                                  <div class="age2">{{ liuYueData[index - 1].lunarMonth + '/' + liuYueData[index - 1].shiErJie
                                }}</div>
                                  <div class="year">{{ liuYueData[index - 1].solarMonthDay }}</div>
                                  <div class="ganZhi">
                                    <span v-html="ganZhiGaoLiangMethod2(liuYueData[index - 1].ganZhi)"></span>
                                  </div>
                                  <div class="shiShen">
                                    <div class="l">
                                      {{ liuYueData[index - 1].tianShen.substring(0, 1) }}<br />{{ liuYueData[index -
                                      1].tianShen.substring(1, 2) }}
                                    </div>
                                    <div class="r">
                                      {{ liuYueData[index - 1].diShen.substring(0, 1) }}<br />{{ liuYueData[index -
                                      1].diShen.substring(1, 2) }}
                                    </div>
                                  </div>
                                </div>
                              </span>
                            </span>
                          </div>
                        </div>
                      </div>

                      <div
                        class="dayunliunian1"
                        v-if="isLiuRiData"
                      >
                        <div class="title">
                          <div class="item"><b>流<br />日</b></div>
                        </div>
                        <div class="content">
                          <div class="item">
                            <span
                              v-for="index in liuRiData.length"
                              :key="index"
                            >
                              <span v-if="liuRiLun == index">
                                <div class="one-yes">
                                  <div class="age">{{ liuRiData[index - 1].lunarDay }}</div>
                                  <div class="year">{{ liuRiData[index - 1].solarDay }}</div>
                                  <div class="ganZhi">
                                    <span v-html="ganZhiGaoLiangMethod2(liuRiData[index - 1].ganZhi)"></span>
                                  </div>
                                  <div class="shiShen">
                                    <div class="l">
                                      {{ liuRiData[index - 1].tianShen.substring(0, 1) }}<br />{{ liuRiData[index -
                                      1].tianShen.substring(1, 2) }}
                                    </div>
                                    <div class="r">
                                      {{ liuRiData[index - 1].diShen.substring(0, 1) }}<br />{{ liuRiData[index -
                                      1].diShen.substring(1, 2) }}
                                    </div>
                                  </div>
                                </div>
                              </span>
                              <span v-else>
                                <div
                                  class="one-no"
                                  @click="liuRiMethod(index, liuRiData[index - 1].ganZhi, liuRiData[index - 1].solarDate)"
                                >
                                  <div class="age">{{ liuRiData[index - 1].lunarDay }}</div>
                                  <div class="year">{{ liuRiData[index - 1].solarDay }}</div>
                                  <div class="ganZhi">
                                    <span v-html="ganZhiGaoLiangMethod2(liuRiData[index - 1].ganZhi)"></span>
                                  </div>
                                  <div class="shiShen">
                                    <div class="l">
                                      {{ liuRiData[index - 1].tianShen.substring(0, 1) }}<br />{{ liuRiData[index -
                                      1].tianShen.substring(1, 2) }}
                                    </div>
                                    <div class="r">
                                      {{ liuRiData[index - 1].diShen.substring(0, 1) }}<br />{{ liuRiData[index -
                                      1].diShen.substring(1, 2) }}
                                    </div>
                                  </div>
                                </div>
                              </span>
                            </span>
                          </div>
                        </div>
                      </div>

                      <div
                        class="dayunliunian1"
                        v-if="isLiuShiData"
                      >
                        <div class="title">
                          <div class="item"><b>流<br />时</b></div>
                        </div>
                        <div class="content">
                          <div class="item">
                            <span
                              v-for="index in liuShiData.length"
                              :key="index"
                            >
                              <span v-if="liuShiLun === index">
                                <div class="one-yes">
                                  <div class="age">{{ liuShiData[index - 1].shiErShiChenHaMing }}</div>
                                  <div class="year">{{ liuShiData[index - 1].solarHour }}</div>
                                  <div class="ganZhi">
                                    <span v-html="ganZhiGaoLiangMethod2(liuShiData[index - 1].ganZhi)"></span>
                                  </div>
                                  <div class="shiShen">
                                    <div class="l">
                                      {{ liuShiData[index - 1].tianShen.substring(0, 1) }}<br />{{ liuShiData[index -
                                      1].tianShen.substring(1, 2) }}
                                    </div>
                                    <div class="r">
                                      {{ liuShiData[index - 1].diShen.substring(0, 1) }}<br />{{ liuShiData[index -
                                      1].diShen.substring(1, 2) }}
                                    </div>
                                  </div>
                                </div>
                              </span>
                              <span v-else>
                                <div
                                  class="one-no"
                                  @click="liuShiMethod(index, liuShiData[index - 1].ganZhi)"
                                >
                                  <div class="age">{{ liuShiData[index - 1].shiErShiChenHaMing }}</div>
                                  <div class="year">{{ liuShiData[index - 1].solarHour }}</div>
                                  <div class="ganZhi">
                                    <span v-html="ganZhiGaoLiangMethod2(liuShiData[index - 1].ganZhi)"></span>
                                  </div>
                                  <div class="shiShen">
                                    <div class="l">
                                      {{ liuShiData[index - 1].tianShen.substring(0, 1) }}<br />{{ liuShiData[index -
                                      1].tianShen.substring(1, 2) }}
                                    </div>
                                    <div class="r">
                                      {{ liuShiData[index - 1].diShen.substring(0, 1) }}<br />{{ liuShiData[index -
                                      1].diShen.substring(1, 2) }}
                                    </div>
                                  </div>
                                </div>
                              </span>
                            </span>
                          </div>
                        </div>
                      </div>

                    </div>

                    <!-- 详细模式 -->
                    <div v-if="daYunLiuNianMode === 2">

                      <div class="dayunliunian2">

                        <div
                          class="title cursor"
                          @click="daYunLiuNianModeMethod"
                        >
                          <div class="item">
                            <b>大<br />运</b>
                          </div>
                        </div>

                        <div class="title2">
                          <div class="nianling">年龄</div>
                          <div class="nianfen">年份</div>
                          <div class="zhuxing">主星</div>
                          <div class="tiangan">天干</div>
                          <div class="dizhi">地支</div>
                          <div class="canggan">藏干</div>
                          <div class="fuxing">副星</div>
                          <div class="zizuo">自坐</div>
                          <div class="xingyun">星运</div>
                          <div class="kongwang">空亡</div>
                          <div class="nayin">纳音</div>
                        </div>

                        <div class="content">
                          <div class="item">
                            <span
                              v-for="index in daYunData.length"
                              :key="index"
                            >
                              <span v-if="daYunLun === index">
                                <div class="one-yes">
                                  <div class="age">{{ daYunData[index - 1].age }}岁</div>
                                  <div class="year">{{ daYunData[index - 1].solarYear }}年</div>
                                  <span v-if="index !== 1">
                                    <div class="zhuXing">
                                      {{ daYunData[index - 1].tianShen }}
                                    </div>
                                    <div class="gan">
                                      <b v-html="ganZhiGaoLiangMethod(daYunData[index - 1].ganZhi.substring(0, 1))"></b><span
                                        class="sx"
                                        v-html="ganZhiInWuXingGaoLiangMethod(daYunData[index - 1].ganZhi.substring(0, 1))"
                                      ></span>
                                    </div>
                                    <div class="zhi">
                                      <b v-html="ganZhiGaoLiangMethod(daYunData[index - 1].ganZhi.substring(1, 2))"></b><span
                                        class="sx"
                                        v-html="ganZhiInWuXingGaoLiangMethod(daYunData[index - 1].ganZhi.substring(1, 2))"
                                      ></span>
                                    </div>
                                    <div class="cangGan">
                                      <div
                                        v-for="item in daYunData[index - 1].cangGan.split('-')"
                                        :key="item"
                                      >
                                        <b v-html="ganZhiGaoLiangMethod(item)"></b><span v-html="ganZhiInWuXingGaoLiangMethod(item)"></span>
                                      </div>
                                    </div>
                                    <div class="fuXing">
                                      <div
                                        v-for="item in daYunData[index - 1].fuXing.split('-')"
                                        :key="item"
                                      >
                                        {{ item }}
                                      </div>
                                    </div>
                                    <div class="ziZuo">
                                      {{ daYunData[index - 1].ziZuo }}
                                    </div>
                                    <div class="xingYun">
                                      {{ daYunData[index - 1].xingYun }}
                                    </div>
                                    <div class="kongWang">
                                      <span v-html="ganZhiGaoLiangMethod(daYunData[index - 1].kongWang.substring(0, 1))"></span>
                                      <span v-html="ganZhiGaoLiangMethod(daYunData[index - 1].kongWang.substring(1, 2))"></span>
                                    </div>
                                    <div class="naYin">
                                      {{ daYunData[index - 1].naYin }}
                                    </div>
                                  </span>
                                  <span v-else>
                                    <div class="xiaoyun">小<br />运</div>
                                  </span>
                                </div>
                              </span>
                              <span v-else>
                                <div
                                  class="one-no"
                                  @click="daYunMethod(index, daYunData[index - 1].ganZhi, daYunData[index - 1].solarDate)"
                                >
                                  <div class="age">{{ daYunData[index - 1].age }}岁</div>
                                  <div class="year">{{ daYunData[index - 1].solarYear }}年</div>
                                  <span v-if="index !== 1">
                                    <div class="zhuXing">
                                      {{ daYunData[index - 1].tianShen }}
                                    </div>
                                    <div class="gan">
                                      <b v-html="ganZhiGaoLiangMethod(daYunData[index - 1].ganZhi.substring(0, 1))"></b><span
                                        class="sx"
                                        v-html="ganZhiInWuXingGaoLiangMethod(daYunData[index - 1].ganZhi.substring(0, 1))"
                                      ></span>
                                    </div>
                                    <div class="zhi">
                                      <b v-html="ganZhiGaoLiangMethod(daYunData[index - 1].ganZhi.substring(1, 2))"></b><span
                                        class="sx"
                                        v-html="ganZhiInWuXingGaoLiangMethod(daYunData[index - 1].ganZhi.substring(1, 2))"
                                      ></span>
                                    </div>
                                    <div class="cangGan">
                                      <div
                                        v-for="item in daYunData[index - 1].cangGan.split('-')"
                                        :key="item"
                                      >
                                        <b v-html="ganZhiGaoLiangMethod(item)"></b><span v-html="ganZhiInWuXingGaoLiangMethod(item)"></span>
                                      </div>
                                    </div>
                                    <div class="fuXing">
                                      <div
                                        v-for="item in daYunData[index - 1].fuXing.split('-')"
                                        :key="item"
                                      >
                                        {{ item }}
                                      </div>
                                    </div>
                                    <div class="ziZuo">
                                      {{ daYunData[index - 1].ziZuo }}
                                    </div>
                                    <div class="xingYun">
                                      {{ daYunData[index - 1].xingYun }}
                                    </div>
                                    <div class="kongWang">
                                      <span v-html="ganZhiGaoLiangMethod(daYunData[index - 1].kongWang.substring(0, 1))"></span>
                                      <span v-html="ganZhiGaoLiangMethod(daYunData[index - 1].kongWang.substring(1, 2))"></span>
                                    </div>
                                    <div class="naYin">
                                      {{ daYunData[index - 1].naYin }}
                                    </div>
                                  </span>
                                  <span v-else>
                                    <div class="xiaoyun">小<br />运</div>
                                  </span>
                                </div>
                              </span>
                            </span>
                          </div>
                        </div>

                      </div>

                      <div class="dayunliunian2">

                        <div class="title">
                          <div class="item"><b>流<br />年</b></div>
                        </div>

                        <div class="title2">
                          <div class="nianling">年龄</div>
                          <div class="nianfen">年份</div>
                          <div class="zhuxing">主星</div>
                          <div class="tiangan">天干</div>
                          <div class="dizhi">地支</div>
                          <div class="canggan">藏干</div>
                          <div class="fuxing">副星</div>
                          <div class="zizuo">自坐</div>
                          <div class="xingyun">星运</div>
                          <div class="kongwang">空亡</div>
                          <div class="nayin">纳音</div>
                        </div>

                        <div class="content">
                          <div class="item">
                            <span
                              v-for="index in liuNianData.length"
                              :key="index"
                            >
                              <span v-if="liuNianLun === index">
                                <div class="one-yes">
                                  <div class="age">{{ liuNianData[index - 1].age }}岁</div>
                                  <div class="year">{{ liuNianData[index - 1].solarYear }}年</div>
                                  <div class="zhuXing">
                                    {{ liuNianData[index - 1].tianShen }}
                                  </div>
                                  <div class="gan">
                                    <b v-html="ganZhiGaoLiangMethod(liuNianData[index - 1].ganZhi.substring(0, 1))"></b><span
                                      class="sx"
                                      v-html="ganZhiInWuXingGaoLiangMethod(liuNianData[index - 1].ganZhi.substring(0, 1))"
                                    ></span>
                                  </div>
                                  <div class="zhi">
                                    <b v-html="ganZhiGaoLiangMethod(liuNianData[index - 1].ganZhi.substring(1, 2))"></b><span
                                      class="sx"
                                      v-html="ganZhiInWuXingGaoLiangMethod(liuNianData[index - 1].ganZhi.substring(1, 2))"
                                    ></span>
                                  </div>
                                  <div class="cangGan">
                                    <div
                                      v-for="item in liuNianData[index - 1].cangGan.split('-')"
                                      :key="item"
                                    >
                                      <b v-html="ganZhiGaoLiangMethod(item)"></b><span v-html="ganZhiInWuXingGaoLiangMethod(item)"></span>
                                    </div>
                                  </div>
                                  <div class="fuXing">
                                    <div
                                      v-for="item in liuNianData[index - 1].fuXing.split('-')"
                                      :key="item"
                                    >
                                      {{ item }}
                                    </div>
                                  </div>
                                  <div class="ziZuo">
                                    {{ liuNianData[index - 1].ziZuo }}
                                  </div>
                                  <div class="xingYun">
                                    {{ liuNianData[index - 1].xingYun }}
                                  </div>
                                  <div class="kongWang">
                                    <span v-html="ganZhiGaoLiangMethod(liuNianData[index - 1].kongWang.substring(0, 1))"></span>
                                    <span v-html="ganZhiGaoLiangMethod(liuNianData[index - 1].kongWang.substring(1, 2))"></span>
                                  </div>
                                  <div class="naYin">
                                    {{ liuNianData[index - 1].naYin }}
                                  </div>
                                </div>
                              </span>
                              <span v-else>
                                <div
                                  class="one-no"
                                  @click="liuNianMethod(index, liuNianData[index - 1].ganZhi, liuNianData[index - 1].solarDate)"
                                >
                                  <div class="age">{{ liuNianData[index - 1].age }}岁</div>
                                  <div class="year">{{ liuNianData[index - 1].solarYear }}年</div>
                                  <div class="zhuXing">
                                    {{ liuNianData[index - 1].tianShen }}
                                  </div>
                                  <div class="gan">
                                    <b v-html="ganZhiGaoLiangMethod(liuNianData[index - 1].ganZhi.substring(0, 1))"></b><span
                                      class="sx"
                                      v-html="ganZhiInWuXingGaoLiangMethod(liuNianData[index - 1].ganZhi.substring(0, 1))"
                                    ></span>
                                  </div>
                                  <div class="zhi">
                                    <b v-html="ganZhiGaoLiangMethod(liuNianData[index - 1].ganZhi.substring(1, 2))"></b><span
                                      class="sx"
                                      v-html="ganZhiInWuXingGaoLiangMethod(liuNianData[index - 1].ganZhi.substring(1, 2))"
                                    ></span>
                                  </div>
                                  <div class="cangGan">
                                    <div
                                      v-for="item in liuNianData[index - 1].cangGan.split('-')"
                                      :key="item"
                                    >
                                      <b v-html="ganZhiGaoLiangMethod(item)"></b><span v-html="ganZhiInWuXingGaoLiangMethod(item)"></span>
                                    </div>
                                  </div>
                                  <div class="fuXing">
                                    <div
                                      v-for="item in liuNianData[index - 1].fuXing.split('-')"
                                      :key="item"
                                    >
                                      {{ item }}
                                    </div>
                                  </div>
                                  <div class="ziZuo">
                                    {{ liuNianData[index - 1].ziZuo }}
                                  </div>
                                  <div class="xingYun">
                                    {{ liuNianData[index - 1].xingYun }}
                                  </div>
                                  <div class="kongWang">
                                    <span v-html="ganZhiGaoLiangMethod(liuNianData[index - 1].kongWang.substring(0, 1))"></span>
                                    <span v-html="ganZhiGaoLiangMethod(liuNianData[index - 1].kongWang.substring(1, 2))"></span>
                                  </div>
                                  <div class="naYin">
                                    {{ liuNianData[index - 1].naYin }}
                                  </div>
                                </div>
                              </span>
                            </span>
                          </div>
                        </div>

                      </div>

                      <div class="dayunliunian2">

                        <div class="title">
                          <div class="item"><b>小<br />运</b></div>
                        </div>

                        <div class="title2">
                          <div class="nianling">--</div>
                          <div class="nianfen">--</div>
                          <div class="zhuxing">主星</div>
                          <div class="tiangan">天干</div>
                          <div class="dizhi">地支</div>
                          <div class="canggan">藏干</div>
                          <div class="fuxing">副星</div>
                          <div class="zizuo">自坐</div>
                          <div class="xingyun">星运</div>
                          <div class="kongwang">空亡</div>
                          <div class="nayin">纳音</div>
                        </div>

                        <div class="content">
                          <div class="item">
                            <span
                              v-for="index in xiaoYunData.length"
                              :key="index"
                            >
                              <span v-if="liuNianLun === index">
                                <div class="one-yes">
                                  <div class="age">- -</div>
                                  <div class="year">- -</div>
                                  <div class="zhuXing">
                                    {{ xiaoYunData[index - 1].tianShen }}
                                  </div>
                                  <div class="gan">
                                    <b v-html="ganZhiGaoLiangMethod(xiaoYunData[index - 1].ganZhi.substring(0, 1))"></b><span
                                      class="sx"
                                      v-html="ganZhiInWuXingGaoLiangMethod(xiaoYunData[index - 1].ganZhi.substring(0, 1))"
                                    ></span>
                                  </div>
                                  <div class="zhi">
                                    <b v-html="ganZhiGaoLiangMethod(xiaoYunData[index - 1].ganZhi.substring(1, 2))"></b><span
                                      class="sx"
                                      v-html="ganZhiInWuXingGaoLiangMethod(xiaoYunData[index - 1].ganZhi.substring(1, 2))"
                                    ></span>
                                  </div>
                                  <div class="cangGan">
                                    <div
                                      v-for="item in xiaoYunData[index - 1].cangGan.split('-')"
                                      :key="item"
                                    >
                                      <b v-html="ganZhiGaoLiangMethod(item)"></b><span v-html="ganZhiInWuXingGaoLiangMethod(item)"></span>
                                    </div>
                                  </div>
                                  <div class="fuXing">
                                    <div
                                      v-for="item in xiaoYunData[index - 1].fuXing.split('-')"
                                      :key="item"
                                    >
                                      {{ item }}
                                    </div>
                                  </div>
                                  <div class="ziZuo">
                                    {{ xiaoYunData[index - 1].ziZuo }}
                                  </div>
                                  <div class="xingYun">
                                    {{ xiaoYunData[index - 1].xingYun }}
                                  </div>
                                  <div class="kongWang">
                                    <span v-html="ganZhiGaoLiangMethod(xiaoYunData[index - 1].kongWang.substring(0, 1))"></span>
                                    <span v-html="ganZhiGaoLiangMethod(xiaoYunData[index - 1].kongWang.substring(1, 2))"></span>
                                  </div>
                                  <div class="naYin">
                                    {{ xiaoYunData[index - 1].naYin }}
                                  </div>
                                </div>
                              </span>
                              <span v-else>
                                <div
                                  class="one-no"
                                  @click="liuNianMethod(index, liuNianData[index - 1].ganZhi, xiaoYunData[index - 1].solarDate)"
                                >
                                  <div class="age">- -</div>
                                  <div class="year">- -</div>
                                  <div class="zhuXing">
                                    {{ xiaoYunData[index - 1].tianShen }}
                                  </div>
                                  <div class="gan">
                                    <b v-html="ganZhiGaoLiangMethod(xiaoYunData[index - 1].ganZhi.substring(0, 1))"></b><span
                                      class="sx"
                                      v-html="ganZhiInWuXingGaoLiangMethod(xiaoYunData[index - 1].ganZhi.substring(0, 1))"
                                    ></span>
                                  </div>
                                  <div class="zhi">
                                    <b v-html="ganZhiGaoLiangMethod(xiaoYunData[index - 1].ganZhi.substring(1, 2))"></b><span
                                      class="sx"
                                      v-html="ganZhiInWuXingGaoLiangMethod(xiaoYunData[index - 1].ganZhi.substring(1, 2))"
                                    ></span>
                                  </div>
                                  <div class="cangGan">
                                    <div
                                      v-for="item in xiaoYunData[index - 1].cangGan.split('-')"
                                      :key="item"
                                    >
                                      <b v-html="ganZhiGaoLiangMethod(item)"></b><span v-html="ganZhiInWuXingGaoLiangMethod(item)"></span>
                                    </div>
                                  </div>
                                  <div class="fuXing">
                                    <div
                                      v-for="item in xiaoYunData[index - 1].fuXing.split('-')"
                                      :key="item"
                                    >
                                      {{ item }}
                                    </div>
                                  </div>
                                  <div class="ziZuo">
                                    {{ xiaoYunData[index - 1].ziZuo }}
                                  </div>
                                  <div class="xingYun">
                                    {{ xiaoYunData[index - 1].xingYun }}
                                  </div>
                                  <div class="kongWang">
                                    <span v-html="ganZhiGaoLiangMethod(xiaoYunData[index - 1].kongWang.substring(0, 1))"></span>
                                    <span v-html="ganZhiGaoLiangMethod(xiaoYunData[index - 1].kongWang.substring(1, 2))"></span>
                                  </div>
                                  <div class="naYin">
                                    {{ xiaoYunData[index - 1].naYin }}
                                  </div>
                                </div>
                              </span>
                            </span>
                          </div>
                        </div>
                      </div>

                      <div class="dayunliunian2">

                        <div class="title">
                          <div class="item"><b>流<br />月</b></div>
                        </div>

                        <div class="title2">
                          <div class="nianling">公历月</div>
                          <div class="nianfen">农历月</div>
                          <div class="zhuxing">主星</div>
                          <div class="tiangan">天干</div>
                          <div class="dizhi">地支</div>
                          <div class="canggan">藏干</div>
                          <div class="fuxing">副星</div>
                          <div class="zizuo">自坐</div>
                          <div class="xingyun">星运</div>
                          <div class="kongwang">空亡</div>
                          <div class="nayin">纳音</div>
                        </div>

                        <div class="content">
                          <div class="item">
                            <span
                              v-for="index in liuYueData.length"
                              :key="index"
                            >
                              <span v-if="liuYueLun === index">
                                <div class="one-yes">
                                  <div class="age">{{ liuYueData[index - 1].solarMonthDay }}</div>
                                  <div class="year">{{ liuYueData[index - 1].lunarMonth }}/{{ liuYueData[index - 1].shiErJie
                                      }}
                                  </div>
                                  <div class="zhuXing">
                                    {{ liuYueData[index - 1].tianShen }}
                                  </div>
                                  <div class="gan">
                                    <b v-html="ganZhiGaoLiangMethod(liuYueData[index - 1].ganZhi.substring(0, 1))"></b><span
                                      class="sx"
                                      v-html="ganZhiInWuXingGaoLiangMethod(liuYueData[index - 1].ganZhi.substring(0, 1))"
                                    ></span>
                                  </div>
                                  <div class="zhi">
                                    <b v-html="ganZhiGaoLiangMethod(liuYueData[index - 1].ganZhi.substring(1, 2))"></b><span
                                      class="sx"
                                      v-html="ganZhiInWuXingGaoLiangMethod(liuYueData[index - 1].ganZhi.substring(1, 2))"
                                    ></span>
                                  </div>
                                  <div class="cangGan">
                                    <div
                                      v-for="item in liuYueData[index - 1].cangGan.split('-')"
                                      :key="item"
                                    >
                                      <span v-html="ganZhiGaoLiangMethod(item)"></span><span v-html="ganZhiInWuXingGaoLiangMethod(item)"></span>
                                    </div>
                                  </div>
                                  <div class="fuXing">
                                    <div
                                      v-for="item in liuYueData[index - 1].fuXing.split('-')"
                                      :key="item"
                                    >
                                      {{ item }}
                                    </div>
                                  </div>
                                  <div class="ziZuo">
                                    {{ liuYueData[index - 1].ziZuo }}
                                  </div>
                                  <div class="xingYun">
                                    {{ liuYueData[index - 1].xingYun }}
                                  </div>
                                  <div class="kongWang">
                                    <span v-html="ganZhiGaoLiangMethod(liuYueData[index - 1].kongWang.substring(0, 1))"></span>
                                    <span v-html="ganZhiGaoLiangMethod(liuYueData[index - 1].kongWang.substring(1, 2))"></span>
                                  </div>
                                  <div class="naYin">
                                    {{ liuYueData[index - 1].naYin }}
                                  </div>
                                </div>
                              </span>
                              <span v-else>
                                <div
                                  class="one-no"
                                  @click="liuYueMethod(index, liuYueData[index - 1].ganZhi, liuYueData[index - 1].solarDate)"
                                >
                                  <div class="age">{{ liuYueData[index - 1].solarMonthDay }}</div>
                                  <div class="year">{{ liuYueData[index - 1].lunarMonth }}/{{ liuYueData[index - 1].shiErJie
                                      }}
                                  </div>
                                  <div class="zhuXing">
                                    {{ liuYueData[index - 1].tianShen }}
                                  </div>
                                  <div class="gan">
                                    <b v-html="ganZhiGaoLiangMethod(liuYueData[index - 1].ganZhi.substring(0, 1))"></b><span
                                      class="sx"
                                      v-html="ganZhiInWuXingGaoLiangMethod(liuYueData[index - 1].ganZhi.substring(0, 1))"
                                    ></span>
                                  </div>
                                  <div class="zhi">
                                    <b v-html="ganZhiGaoLiangMethod(liuYueData[index - 1].ganZhi.substring(1, 2))"></b><span
                                      class="sx"
                                      v-html="ganZhiInWuXingGaoLiangMethod(liuYueData[index - 1].ganZhi.substring(1, 2))"
                                    ></span>
                                  </div>
                                  <div class="cangGan">
                                    <div
                                      v-for="item in liuYueData[index - 1].cangGan.split('-')"
                                      :key="item"
                                    >
                                      <span v-html="ganZhiGaoLiangMethod(item)"></span><span v-html="ganZhiInWuXingGaoLiangMethod(item)"></span>
                                    </div>
                                  </div>
                                  <div class="fuXing">
                                    <div
                                      v-for="item in liuYueData[index - 1].fuXing.split('-')"
                                      :key="item"
                                    >
                                      {{ item }}
                                    </div>
                                  </div>
                                  <div class="ziZuo">
                                    {{ liuYueData[index - 1].ziZuo }}
                                  </div>
                                  <div class="xingYun">
                                    {{ liuYueData[index - 1].xingYun }}
                                  </div>
                                  <div class="kongWang">
                                    <span v-html="ganZhiGaoLiangMethod(liuYueData[index - 1].kongWang.substring(0, 1))"></span>
                                    <span v-html="ganZhiGaoLiangMethod(liuYueData[index - 1].kongWang.substring(1, 2))"></span>
                                  </div>
                                  <div class="naYin">
                                    {{ liuYueData[index - 1].naYin }}
                                  </div>
                                </div>
                              </span>
                            </span>
                          </div>
                        </div>
                      </div>

                      <div
                        class="dayunliunian2"
                        v-if="isLiuRiData"
                      >

                        <div class="title">
                          <div class="item"><b>流<br />日</b></div>
                        </div>

                        <div class="title2">
                          <div class="nianling">公历日</div>
                          <div class="nianfen">农历日</div>
                          <div class="zhuxing">主星</div>
                          <div class="tiangan">天干</div>
                          <div class="dizhi">地支</div>
                          <div class="canggan">藏干</div>
                          <div class="fuxing">副星</div>
                          <div class="zizuo">自坐</div>
                          <div class="xingyun">星运</div>
                          <div class="kongwang">空亡</div>
                          <div class="nayin">纳音</div>
                        </div>

                        <div class="content">
                          <div class="item">
                            <span
                              v-for="index in liuRiData.length"
                              :key="index"
                            >
                              <span v-if="liuRiLun == index">
                                <div class="one-yes">
                                  <div class="age">{{ liuRiData[index - 1].solarDay }}</div>
                                  <div class="year">{{ liuRiData[index - 1].lunarDay }}</div>
                                  <div class="zhuXing">
                                    {{ liuRiData[index - 1].tianShen }}
                                  </div>
                                  <div class="gan">
                                    <b v-html="ganZhiGaoLiangMethod(liuRiData[index - 1].ganZhi.substring(0, 1))"></b><span
                                      class="sx"
                                      v-html="ganZhiInWuXingGaoLiangMethod(liuRiData[index - 1].ganZhi.substring(0, 1))"
                                    ></span>
                                  </div>
                                  <div class="zhi">
                                    <b v-html="ganZhiGaoLiangMethod(liuRiData[index - 1].ganZhi.substring(1, 2))"></b><span
                                      class="sx"
                                      v-html="ganZhiInWuXingGaoLiangMethod(liuRiData[index - 1].ganZhi.substring(1, 2))"
                                    ></span>
                                  </div>
                                  <div class="cangGan">
                                    <div
                                      v-for="item in liuRiData[index - 1].cangGan.split('-')"
                                      :key="item"
                                    >
                                      <span v-html="ganZhiGaoLiangMethod(item)"></span><span v-html="ganZhiInWuXingGaoLiangMethod(item)"></span>
                                    </div>
                                  </div>
                                  <div class="fuXing">
                                    <div
                                      v-for="item in liuRiData[index - 1].fuXing.split('-')"
                                      :key="item"
                                    >
                                      {{ item }}
                                    </div>
                                  </div>
                                  <div class="ziZuo">
                                    {{ liuRiData[index - 1].ziZuo }}
                                  </div>
                                  <div class="xingYun">
                                    {{ liuRiData[index - 1].xingYun }}
                                  </div>
                                  <div class="kongWang">
                                    <span v-html="ganZhiGaoLiangMethod(liuRiData[index - 1].kongWang.substring(0, 1))"></span>
                                    <span v-html="ganZhiGaoLiangMethod(liuRiData[index - 1].kongWang.substring(1, 2))"></span>
                                  </div>
                                  <div class="naYin">
                                    {{ liuRiData[index - 1].naYin }}
                                  </div>
                                </div>
                              </span>
                              <span v-else>
                                <div
                                  class="one-no"
                                  @click="liuRiMethod(index, liuRiData[index - 1].ganZhi, liuRiData[index - 1].solarDate)"
                                >
                                  <div class="age">{{ liuRiData[index - 1].solarDay }}</div>
                                  <div class="year">{{ liuRiData[index - 1].lunarDay }}</div>
                                  <div class="zhuXing">
                                    {{ liuRiData[index - 1].tianShen }}
                                  </div>
                                  <div class="gan">
                                    <b v-html="ganZhiGaoLiangMethod(liuRiData[index - 1].ganZhi.substring(0, 1))"></b><span
                                      class="sx"
                                      v-html="ganZhiInWuXingGaoLiangMethod(liuRiData[index - 1].ganZhi.substring(0, 1))"
                                    ></span>
                                  </div>
                                  <div class="zhi">
                                    <b v-html="ganZhiGaoLiangMethod(liuRiData[index - 1].ganZhi.substring(1, 2))"></b><span
                                      class="sx"
                                      v-html="ganZhiInWuXingGaoLiangMethod(liuRiData[index - 1].ganZhi.substring(1, 2))"
                                    ></span>
                                  </div>
                                  <div class="cangGan">
                                    <div
                                      v-for="item in liuRiData[index - 1].cangGan.split('-')"
                                      :key="item"
                                    >
                                      <span v-html="ganZhiGaoLiangMethod(item)"></span><span v-html="ganZhiInWuXingGaoLiangMethod(item)"></span>
                                    </div>
                                  </div>
                                  <div class="fuXing">
                                    <div
                                      v-for="item in liuRiData[index - 1].fuXing.split('-')"
                                      :key="item"
                                    >
                                      {{ item }}
                                    </div>
                                  </div>
                                  <div class="ziZuo">
                                    {{ liuRiData[index - 1].ziZuo }}
                                  </div>
                                  <div class="xingYun">
                                    {{ liuRiData[index - 1].xingYun }}
                                  </div>
                                  <div class="kongWang">
                                    <span v-html="ganZhiGaoLiangMethod(liuRiData[index - 1].kongWang.substring(0, 1))"></span>
                                    <span v-html="ganZhiGaoLiangMethod(liuRiData[index - 1].kongWang.substring(1, 2))"></span>
                                  </div>
                                  <div class="naYin">
                                    {{ liuRiData[index - 1].naYin }}
                                  </div>
                                </div>
                              </span>
                            </span>
                          </div>
                        </div>
                      </div>

                      <div
                        class="dayunliunian2"
                        v-if="isLiuShiData"
                      >

                        <div class="title">
                          <div class="item"><b>流<br />时</b></div>
                        </div>

                        <div class="title2">
                          <div class="nianling2">天色纪时</div>
                          <div class="nianfen">时辰</div>
                          <div class="zhuxing">主星</div>
                          <div class="tiangan">天干</div>
                          <div class="dizhi">地支</div>
                          <div class="canggan">藏干</div>
                          <div class="fuxing">副星</div>
                          <div class="zizuo">自坐</div>
                          <div class="xingyun">星运</div>
                          <div class="kongwang">空亡</div>
                          <div class="nayin">纳音</div>
                        </div>

                        <div class="content">
                          <div class="item">
                            <span
                              v-for="index in liuShiData.length"
                              :key="index"
                            >
                              <span v-if="liuShiLun === index">
                                <div class="one-yes">
                                  <div class="age">{{ liuShiData[index - 1].shiErShiChenHaMing }}</div>
                                  <div class="year">{{ liuShiData[index - 1].solarHour }}</div>
                                  <div class="zhuXing">
                                    {{ liuShiData[index - 1].tianShen }}
                                  </div>
                                  <div class="gan">
                                    <b v-html="ganZhiGaoLiangMethod(liuShiData[index - 1].ganZhi.substring(0, 1))"></b><span
                                      class="sx"
                                      v-html="ganZhiInWuXingGaoLiangMethod(liuShiData[index - 1].ganZhi.substring(0, 1))"
                                    ></span>
                                  </div>
                                  <div class="zhi">
                                    <b v-html="ganZhiGaoLiangMethod(liuShiData[index - 1].ganZhi.substring(1, 2))"></b><span
                                      class="sx"
                                      v-html="ganZhiInWuXingGaoLiangMethod(liuShiData[index - 1].ganZhi.substring(1, 2))"
                                    ></span>
                                  </div>
                                  <div class="cangGan">
                                    <div
                                      v-for="item in liuShiData[index - 1].cangGan.split('-')"
                                      :key="item"
                                    >
                                      <span v-html="ganZhiGaoLiangMethod(item)"></span><span v-html="ganZhiInWuXingGaoLiangMethod(item)"></span>
                                    </div>
                                  </div>
                                  <div class="fuXing">
                                    <div
                                      v-for="item in liuShiData[index - 1].fuXing.split('-')"
                                      :key="item"
                                    >
                                      {{ item }}
                                    </div>
                                  </div>
                                  <div class="ziZuo">
                                    {{ liuShiData[index - 1].ziZuo }}
                                  </div>
                                  <div class="xingYun">
                                    {{ liuShiData[index - 1].xingYun }}
                                  </div>
                                  <div class="kongWang">
                                    <span v-html="ganZhiGaoLiangMethod(liuShiData[index - 1].kongWang.substring(0, 1))"></span>
                                    <span v-html="ganZhiGaoLiangMethod(liuShiData[index - 1].kongWang.substring(1, 2))"></span>
                                  </div>
                                  <div class="naYin">
                                    {{ liuShiData[index - 1].naYin }}
                                  </div>
                                </div>
                              </span>
                              <span v-else>
                                <div
                                  class="one-no"
                                  @click="liuShiMethod(index, liuShiData[index - 1].ganZhi)"
                                >
                                  <div class="age">{{ liuShiData[index - 1].shiErShiChenHaMing }}</div>
                                  <div class="year">{{ liuShiData[index - 1].solarHour }}</div>
                                  <div class="zhuXing">
                                    {{ liuShiData[index - 1].tianShen }}
                                  </div>
                                  <div class="gan">
                                    <b v-html="ganZhiGaoLiangMethod(liuShiData[index - 1].ganZhi.substring(0, 1))"></b><span
                                      class="sx"
                                      v-html="ganZhiInWuXingGaoLiangMethod(liuShiData[index - 1].ganZhi.substring(0, 1))"
                                    ></span>
                                  </div>
                                  <div class="zhi">
                                    <b v-html="ganZhiGaoLiangMethod(liuShiData[index - 1].ganZhi.substring(1, 2))"></b><span
                                      class="sx"
                                      v-html="ganZhiInWuXingGaoLiangMethod(liuShiData[index - 1].ganZhi.substring(1, 2))"
                                    ></span>
                                  </div>
                                  <div class="cangGan">
                                    <div
                                      v-for="item in liuShiData[index - 1].cangGan.split('-')"
                                      :key="item"
                                    >
                                      <span v-html="ganZhiGaoLiangMethod(item)"></span><span v-html="ganZhiInWuXingGaoLiangMethod(item)"></span>
                                    </div>
                                  </div>
                                  <div class="fuXing">
                                    <div
                                      v-for="item in liuShiData[index - 1].fuXing.split('-')"
                                      :key="item"
                                    >
                                      {{ item }}
                                    </div>
                                  </div>
                                  <div class="ziZuo">
                                    {{ liuShiData[index - 1].ziZuo }}
                                  </div>
                                  <div class="xingYun">
                                    {{ liuShiData[index - 1].xingYun }}
                                  </div>
                                  <div class="kongWang">
                                    <span v-html="ganZhiGaoLiangMethod(liuShiData[index - 1].kongWang.substring(0, 1))"></span>
                                    <span v-html="ganZhiGaoLiangMethod(liuShiData[index - 1].kongWang.substring(1, 2))"></span>
                                  </div>
                                  <div class="naYin">
                                    {{ liuShiData[index - 1].naYin }}
                                  </div>
                                </div>
                              </span>
                            </span>
                          </div>
                        </div>
                      </div>

                    </div>

                  </div>

                </div>
                </Col>
              </Row>

              <div class="ganzhiguanxi">
                <div class="mb ml">
                  <span class="title">天干关系：</span>
                  <span v-if="tianGanLiuYi">
                    <span
                      v-if="tianGanLiuYi.length !== 0"
                      class="sp"
                    >
                      {{ tianGanLiuYi.join('、') }}
                    </span>
                    <span
                      v-else
                      class="null"
                    >无数据</span>
                  </span>
                </div>
                <div class="ml">
                  <span class="title">地支关系：</span>
                  <span v-if="diZhiLiuYi">
                    <span
                      v-if="diZhiLiuYi.length !== 0"
                      class="sp"
                    >
                      {{ diZhiLiuYi.join('、') }}
                    </span>
                    <span
                      v-else
                      class="null"
                    >无数据</span>
                  </span>
                </div>
              </div>

            </div>

            <!-- 更多信息 -->
            <div
              class="gengduo"
              v-if="dataPage === 3"
            >
              <div class="go bgi1">
                <div class="item">
                  <div class="title">值年九星</div>
                  <div class="content">
                    {{ data.yearJiuXingAttribute }}
                  </div>
                </div>
                <div class="item">
                  <div class="title">值月九星</div>
                  <div class="content">
                    {{ data.monthJiuXingAttribute }}
                  </div>
                </div>
              </div>

              <div class="go bgi2">
                <div class="item">
                  <div class="title">值日九星</div>
                  <div class="content">
                    {{ data.dayJiuXingAttribute }}
                  </div>
                </div>
                <div class="item">
                  <div class="title">值时九星</div>
                  <div class="content">
                    {{ data.hourJiuXingAttribute }}
                  </div>
                </div>
              </div>

              <div class="go bgi1">
                <div class="item">
                  <div class="title">值年玄空九星</div>
                  <div class="content">
                    {{ data.yearJiuXingXuanKong }}
                  </div>
                </div>
                <div class="item">
                  <div class="title">值月玄空九星</div>
                  <div class="content">
                    {{ data.monthJiuXingXuanKong }}
                  </div>
                </div>
                <div class="item">
                  <div class="title">值日玄空九星</div>
                  <div class="content">
                    {{ data.dayJiuXingXuanKong }}
                  </div>
                </div>
                <div class="item">
                  <div class="title">值时玄空九星</div>
                  <div class="content">
                    {{ data.hourJiuXingXuanKong }}
                  </div>
                </div>
              </div>

              <div class="go bgi2">
                <div class="item">
                  <div class="title">值年北斗九星</div>
                  <div class="content">
                    {{ data.yearJiuXingBeiDou }}
                  </div>
                </div>
                <div class="item">
                  <div class="title">值月北斗九星</div>
                  <div class="content">
                    {{ data.monthJiuXingBeiDou }}
                  </div>
                </div>
                <div class="item">
                  <div class="title">值日北斗九星</div>
                  <div class="content">
                    {{ data.dayJiuXingBeiDou }}
                  </div>
                </div>
                <div class="item">
                  <div class="title">值时北斗九星</div>
                  <div class="content">
                    {{ data.hourJiuXingBeiDou }}
                  </div>
                </div>
              </div>

              <div class="go bgi1">
                <div class="item">
                  <div class="title">值年奇门九星</div>
                  <div class="content">
                    {{ data.yearJiuXingQiMen }}
                  </div>
                </div>
                <div class="item">
                  <div class="title">值月奇门九星</div>
                  <div class="content">
                    {{ data.monthJiuXingQiMen }}
                  </div>
                </div>
                <div class="item">
                  <div class="title">值日奇门九星</div>
                  <div class="content">
                    {{ data.dayJiuXingQiMen }}
                  </div>
                </div>
                <div class="item">
                  <div class="title">值时奇门九星</div>
                  <div class="content">
                    {{ data.hourJiuXingQiMen }}
                  </div>
                </div>
              </div>

              <div class="go bgi2">
                <div class="item">
                  <div class="title">值年太乙九星</div>
                  <div class="content">
                    {{ data.yearJiuXingTaiYi }}
                  </div>
                </div>
                <div class="item">
                  <div class="title">值月太乙九星</div>
                  <div class="content">
                    {{ data.monthJiuXingTaiYi }}
                  </div>
                </div>
                <div class="item">
                  <div class="title">值日太乙九星</div>
                  <div class="content">
                    {{ data.dayJiuXingTaiYi }}
                  </div>
                </div>
                <div class="item">
                  <div class="title">值时太乙九星</div>
                  <div class="content">
                    {{ data.hourJiuXingTaiYi }}
                  </div>
                </div>
              </div>

              <div class="go bgi1">
                <div class="item">
                  <div class="title">年冲生肖</div>
                  <div class="content">
                    {{ data.yearChongShengXiao }}
                  </div>
                </div>
                <div class="item">
                  <div class="title">月冲生肖</div>
                  <div class="content">
                    {{ data.monthChongShengXiao }}
                  </div>
                </div>
                <div class="item">
                  <div class="title">日冲生肖</div>
                  <div class="content">
                    {{ data.dayChongShengXiao}}
                  </div>
                </div>
                <div class="item">
                  <div class="title">时冲生肖</div>
                  <div class="content">
                    {{ data.hourChongShengXiao }}
                  </div>
                </div>
              </div>

              <div class="div">
                <div class="header4">
                  ༺ 星宿 ༻
                </div>
                <div class="shuju">
                  <div class="item">
                    <span class="title">星宿</span>
                    <b class="content">{{ data.xingXiu }}（{{ data.xiuJiXiong }}）</b>
                  </div>
                  <div>
                    <span class="title">歌诀</span>
                    <span>{{ data.xiuJiXiongGeJue }}</span>
                  </div>
                </div>
              </div>

              <div
                class="div"
                v-if="data.guZhong"
              >
                <div class="header4">
                  ༺ 袁天罡称骨 ༻
                </div>
                <div class="shuju">
                  <div class="item">
                    <span class="title">骨重</span>
                    <b class="content">{{ data.guZhong[0] }}</b>
                  </div>
                  <div>
                    <span class="title">批注</span>
                    <span>{{ data.guZhong[1] }}</span>
                  </div>
                </div>
              </div>

              <div class="div">
                <div class="header4">
                  ༺ 日柱论命 ༻
                </div>
                <div class="shuju">
                  <div>
                    <span class="title">参考</span>
                    <span>{{ data.riZhuLunMing }}</span>
                  </div>
                </div>
              </div>

              <div class="div">
                <div class="header4">
                  ༺ 五行分析 ༻
                </div>
                <div class="shuju">
                  <div>
                    <span class="title">参考</span>
                    <span>{{ data.wuXingFenXi }}</span>
                  </div>
                </div>
              </div>

              <div class="div">
                <div class="header4">
                  ༺ 运势分析 ༻
                </div>
                <div class="shuju">
                  <div>
                    <span class="title">参考</span>
                    <span>{{ data.yunShiFenXi }}</span>
                  </div>
                </div>
              </div>

              <div
                class="div"
                v-if="data.xingGeFenXi"
              >
                <div class="header4">
                  ༺ 性格分析 ༻
                </div>
                <div class="shuju">
                  <div>
                    <span class="title">参考</span>
                    <span>{{ data.xingGeFenXi }}</span>
                  </div>
                </div>
              </div>

            </div>

          </div>

        </div>
      </div>

    </div>

  </div>
</template>


<style scoped lang="scss" src="@/css/paipan/bazi.scss"></style>
