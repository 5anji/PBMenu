<script setup>
defineProps({
  "description":{
    type: String,
    required:true
  }
});
</script>

<template>
  <div class="tag">
    <span>{{ description }}</span>
  </div>
</template>
<style scoped lang="scss">
.tag {
  background-color: white;
  padding: 32px 48px;
  border-radius: 8px;
  color: var(--verdeInchis);
  font-size: 24px;
  font-weight: 500;
  letter-spacing: 0.75px;
  box-shadow: rgba(0, 0, 0, 0.08) 0px 4px 12px;
}
</style>
