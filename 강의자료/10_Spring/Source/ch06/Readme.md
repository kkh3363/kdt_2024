- build.gradle 에 추가
- fragment / header.html 에 적용
```
implementation 'org.thymeleaf.extras:thymeleaf-extras-springsecurity6'
```


repository / ItemRepositoryCustomImpl.java
- 다음과 같이 수정 합니다.
- 수정전
```
public Page<Item> getAdminItemPage(ItemSearchDto itemSearchDto, Pageable pageable) {
    QueryResults<Item> results = queryFactory
              .selectFrom(QItem.item)
              .where(regDtsAfter(itemSearchDto.getSearchDateType()),
                  searchSellStatusEq(itemSearchDto.getSearchSellStatus()),
                  searchByLike(itemSearchDto.getSearchBy(), itemSearchDto.getSearchQuery()))
              .orderBy(QItem.item.id.desc())
              .offset((pageable.getOffset()))
              .limit(pageable.getPageSize())
              .fetchResults();

      List<Item> content = results.getResults();
      long total = results.getTotal();
      return new PageImpl<>(content,pageable, total);
}
```
- 수정후
```
public Page<Item> getAdminItemPage(ItemSearchDto itemSearchDto, Pageable pageable) {
    List<Item> content = queryFactory
              .selectFrom(QItem.item)
              .where(regDtsAfter(itemSearchDto.getSearchDateType()),
                  searchSellStatusEq(itemSearchDto.getSearchSellStatus()),
                  searchByLike(itemSearchDto.getSearchBy(), itemSearchDto.getSearchQuery()))
              .orderBy(QItem.item.id.desc())
              .offset((pageable.getOffset()))
              .limit(pageable.getPageSize())
              .fetch();

      long total = content.getTotal();
      return new PageImpl<>(content,pageable, total);
}
```
