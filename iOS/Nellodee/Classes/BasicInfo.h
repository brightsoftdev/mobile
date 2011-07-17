//
//  BasicInfo.h
//  Nellodee
//
//  Created by Ada Hopper on 17/07/11.
//  Copyright 2011 __MyCompanyName__. All rights reserved.
//

#import <Foundation/Foundation.h>

/*
 typedef enum {
    AcademicRelatedStaff,
    AcademicStaff,
    AssistantStaff,
    GraduatedStudent,
    UndergraduatedStudent,
    NonAcademicStaff,
    PostgraduatedStudent,
    ReserchStaff,
    Other
} RolType;
#define RolTypeArray @"Academic Related Staff", @"Academic Staff", @"Assistant Staff", @"Graduated Student",@"Undergraduated Student",@"Non-academic Staff",@"Postgraduated Student",@"Reserch Staff",@"Other", nil
*/

@interface BasicInfo : NSObject {
    NSString *firstName;
    NSString *lastName;
    NSString *prefName;
    NSString *email;
    NSString *rol;
    NSString *departament;
    NSString *college;
    NSArray *tags;

}

@property (nonatomic, retain) NSString *firstName;
@property (nonatomic, retain) NSString *lastName;
@property (nonatomic, retain) NSString *prefName;
@property (nonatomic, retain) NSString *email;
@property (nonatomic, retain) NSString *rol;
@property (nonatomic, retain) NSString *departament;
@property (nonatomic, retain) NSString *college;
@property (nonatomic, retain) NSArray *tags;



@end
