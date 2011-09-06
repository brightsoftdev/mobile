//
//  CategoriesWS.h
//  Nellodee
//
//  Created by Ada Hopper on 21/08/11.
//  Copyright 2011 __MyCompanyName__. All rights reserved.
//

#import <Foundation/Foundation.h>

@class SBJsonStreamParser;
@class SBJsonStreamParserAdapter;

@interface CategoriesWS : NSObject {
	NSMutableData *responseData;
    NSMutableArray *categoriesTags;

}
- (BOOL) meService;

@property (nonatomic, retain) NSMutableData *responseData;
@property (nonatomic, retain) NSMutableArray *categoriesTags;


@end
